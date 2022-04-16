package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
	"strconv"
	"time"
)

/**
 * @author chen
 * @date: 2022/4/14
 * @description:
 **/

func main() {
	members := []int{161487, 161485, 161488, 157646, 161486, 161483, 161484}
	host := "http://192.168.10.16:8084/"
	//host := "http://localhost:8084/"
	body := make(map[string]interface{})
	body["msgType"] = "GROUP_TEXT"
	body["sessionType"] = 1
	body["msgContent"] = "已读测试"
	content, _ := json.Marshal(body)
	url := host + "api/v1/users/161494/sessions/69828/messages"

	handle := func(name int) {
		for i := 0; i < 100; i++ {
			respData, _ := http.Post(url, "application/json", bytes.NewReader(content))
			respBody, _ := ioutil.ReadAll(respData.Body)
			_ = respData.Close
			res := make(map[string]interface{})
			_ = json.Unmarshal(respBody, &res)
			msgId := res["msgId"]
			for i := 0; i < len(members); i++ {
				userId := members[i]
				method := "PATCH"
				messageId := fmt.Sprintf("%.0f", msgId.(float64))

				url := host + "api/v1/users/" + strconv.Itoa(userId) + "/sessions/69828/messages/" + messageId + "/readAck?sessionType=GROUP"
				req, _ := http.NewRequest(method, url, bytes.NewBufferString(""))
				req.Header.Set("Content-Type", "application/json")
				client := &http.Client{}
				_, _ = client.Do(req)
			}
			fmt.Printf("线程%d号,完成%d次\n", name, i)
		}
	}

	for i := 0; i < 100; i++ {
		go handle(i)
	}

	time.Sleep(100000000000000)

}
