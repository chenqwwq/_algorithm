#!/usr/bin/env node

const fs = require("fs");
const path = require("path");

const ROOT = path.resolve(__dirname, "..");
const README = path.join(ROOT, "README.md");

const LANGUAGES = [
  { name: "Java", dir: "src/java", extensions: new Set([".java"]) },
  { name: "C++", dir: "src/cpp", extensions: new Set([".cpp", ".cc", ".cxx"]) },
  { name: "C", dir: "src/c", extensions: new Set([".c"]) },
  { name: "Go", dir: "src/go", extensions: new Set([".go"]) },
];

const SKIP_PARTS = new Set(["template", "common", "_archive"]);
const START = "<!-- PROGRESS:START -->";
const END = "<!-- PROGRESS:END -->";
const CATEGORY_ICONS = new Map([
  ["LeetCode Daily", "📅"],
  ["LeetCode Weekly", "🏁"],
  ["LeetCode Biweekly", "⚡"],
  ["Interview", "💼"],
  ["LeetCode Other", "🧩"],
  ["Other", "📌"],
]);
const LANGUAGE_ICONS = new Map([
  ["Java", "☕"],
  ["C++", "🔷"],
  ["C", "🔹"],
  ["Go", "🐹"],
]);

function walk(dir, callback) {
  if (!fs.existsSync(dir)) return;

  for (const entry of fs.readdirSync(dir, { withFileTypes: true })) {
    const filePath = path.join(dir, entry.name);
    if (entry.isDirectory()) {
      walk(filePath, callback);
    } else if (entry.isFile()) {
      callback(filePath);
    }
  }
}

function shouldSkip(relativePath) {
  const parts = relativePath.split(path.sep);
  if (parts.some((part) => SKIP_PARTS.has(part))) return true;
  return /^Main\.[^.]+$/.test(path.basename(relativePath));
}

function categoryOf(problemKey) {
  if (problemKey.includes("/leetcode/daily/")) return "LeetCode Daily";
  if (problemKey.includes("/leetcode/contest/weekly/")) return "LeetCode Weekly";
  if (problemKey.includes("/leetcode/contest/biweek/")) return "LeetCode Biweekly";
  if (problemKey.includes("/interview")) return "Interview";
  if (problemKey.includes("/leetcode/")) return "LeetCode Other";
  return "Other";
}

function formatDate() {
  return new Intl.DateTimeFormat("zh-CN", {
    timeZone: "Asia/Shanghai",
    year: "numeric",
    month: "2-digit",
    day: "2-digit",
  }).format(new Date());
}

function collectProgress() {
  const allProblems = new Set();
  const byLanguage = new Map();
  const byCategory = new Map();

  for (const language of LANGUAGES) {
    const languageProblems = new Set();
    const baseDir = path.join(ROOT, language.dir);

    walk(baseDir, (filePath) => {
      const ext = path.extname(filePath);
      const relativePath = path.relative(ROOT, filePath);
      if (!language.extensions.has(ext) || shouldSkip(relativePath)) return;

      const problemKey = path.dirname(relativePath).replace(/\\/g, "/");
      languageProblems.add(problemKey);
      allProblems.add(problemKey.replace(/^src\/[^/]+\//, "src/"));
    });

    byLanguage.set(language.name, languageProblems.size);
  }

  for (const problemKey of allProblems) {
    const category = categoryOf(problemKey);
    byCategory.set(category, (byCategory.get(category) || 0) + 1);
  }

  return { total: allProblems.size, byLanguage, byCategory };
}

function table(headers, rows) {
  return [
    `| ${headers[0]} | ${headers[1]} |`,
    "| --- | ---: |",
    ...rows.map(([name, count]) => `| ${name} | ${count} |`),
  ].join("\n");
}

function buildProgressBlock(progress) {
  const categoryOrder = [
    "LeetCode Daily",
    "LeetCode Weekly",
    "LeetCode Biweekly",
    "Interview",
    "LeetCode Other",
    "Other",
  ];
  const categoryRows = categoryOrder
    .filter((name) => progress.byCategory.has(name))
    .map((name) => [`${CATEGORY_ICONS.get(name)} ${name}`, progress.byCategory.get(name)]);
  const languageRows = LANGUAGES
    .map((language) => [
      `${LANGUAGE_ICONS.get(language.name)} ${language.name}`,
      progress.byLanguage.get(language.name) || 0,
    ])
    .filter(([, count]) => count > 0);

  return [
    "## 📊 刷题进度",
    "",
    START,
    `> 自动统计当前活跃题解目录，最近更新：${formatDate()}`,
    "",
    table(["🧭 总览", "数量"], [["题目目录", progress.total]]),
    "",
    "### 🗂️ 按分类",
    "",
    table(["分类", "题目目录"], categoryRows),
    "",
    "### 🧪 按语言",
    "",
    table(["语言", "题目目录"], languageRows),
    END,
  ].join("\n");
}

function updateReadme(block) {
  const original = fs.readFileSync(README, "utf8");
  const sectionPattern = new RegExp(`\\n?## .*刷题进度\\n[\\s\\S]*?${END}\\n*`);

  if (sectionPattern.test(original)) {
    return original.replace(sectionPattern, `\n${block}\n\n`);
  }

  const directoryIndex = original.indexOf("\n## 目录约定");
  if (directoryIndex >= 0) {
    return `${original.slice(0, directoryIndex).trimEnd()}\n\n${block}\n\n${original
      .slice(directoryIndex)
      .trimStart()}`;
  }

  return `${original.trimEnd()}\n\n${block}\n`;
}

const progress = collectProgress();
fs.writeFileSync(README, updateReadme(buildProgressBlock(progress)));
