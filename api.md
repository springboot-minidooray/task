## account api

- 계정 조회: GET /accounts/{id}
    - response 응답

    ```json
    {
    	"id": 123,
    	"email": "abc@asd.as",
    	"password": "비번"
    }
    ```


- 계정 등록: POST /accounts
    - request

    ```json
    {
    	"id": 123,
    	"email": "abc@asd.as",
    	"password": "비번"
    }
    ```

    - response
        - status code : 201

- 계정 수정: PUT /accounts/{id}

    ```json
    {
        "password": "비번"
    }
    ```

- 계정 삭제: DELETE /accounts/{id}

## task api

### 프로젝트

- 프로젝트 목록 조회 : GET /projects/user/{userId}
    - response

      ```json
      [
          {   
              "ProjectId": "",
              "projectName": "프로젝트명",
              "project manager": "관리자 이름",
              "status": "활성"
          }
      ]
      ```

- 프로젝트 조회 : GET /projects/{projectId}
    - response

      ```json
      {
          "projectName": "프로젝트명",
          "project manager": "관리자 이름",
          "tasks": [
            {
              "taskId": "",
              "subject": "",
              "taskStatus": "",
              "taskManagerId": ""
            }     
          ],
          "status": "활성"
      }
      ```

- 프로젝트 등록 : POST /projects
    - request
      ```json
      {
          "projectName": "프로젝트명",
          "project manager": "관리자 이름"
      }
      ```

- 프로젝트 수정 : PUT /projects/{projectId}
    - request
      ```json
      {
          "projectName": "프로젝트명",
          "status": "status"
      }
      ```

- 프로젝트 삭제 : DELETE /projects/{projectId}

### 멤버

- 멤버목록 조회 : GET /projects/{projectId}/members
    - response

    ```json
    [
    	{
    		"projectId": 1,
    		"memberId": 1
    	}
    ]
    ```

- 멤버 조회 : GET /projects/{projectId}/members/{memberId}
    - response 응답

    ```json
    {
    	"projectId": 1,
    	"memberId": 1
    }
    ```

- 멤버 등록 : POST /projects/{projectId}/members

    ```json
    {
    	"projectId": 1,
    	"memberId": 1
    }
    ```

- 멤버 수정 : PUT /projects/{projectId}/members/{memberId}

    ```json
    {
    	"projectId": 1,
    	"memberId": 1
    }
    ```

- 멤버 삭제 : DELETE /projects/{projectId}/members/{memberId}

### 마일스톤

- 마일스톤 조회 : GET /projects/{projectId}/milestones
    - response

    ```json
    [
    	{
    		"name": "name",
    		"startDate": "2010-11-21",
    		"endDate": "2022-10-12"
    	}
    ]
    ```

- 마일스톤 조회 : GET /projects/{projectId}/milestones/{milestoneId}
    - response

    ```json
    {
    	"name": "name",
    	"startDate": "2010-11-21",
    	"endDate": "2022-10-12"
    }
    ```

- 마일스톤 등록 : POST /projects/{projectId}/milestones
    - request

    ```json
    {
    	"name": "name",
    	"startDate": "2010-11-21",
    	"endDate": "2022-10-12"
    }
    ```

- 마일스톤 수정 : PUT /projects/{projectId}/milestones/{milestoneId}
    - request

    ```json
    {
    	"name": "name",
    	"startDate": "2010-11-21",
    	"endDate": "2022-10-12"
    }
    ```

- 마일스톤 삭제 : DELETE /projects/{projectId}/milestones/{milestoneId}

### 업무

- 업무목록 조회 : GET /projects/{projectId}/tasks
    - response

    ```json
    [
    	{
            "taskId": "",
    		"projectName": "프로젝트명",
    		"status": "status",
    		"from": "생성자(관리자)이름"
    	}
    ]
    ```

- 업무 조회 : GET /projects/{projectId}/tasks/{taskId}
    - response 응답

    ```json
    {
        "subject": "",
    	"status": "status",
    	"taskManagerId": "생성자(관리자)이름",
    	"milestone": {
          "milestoneName": ""
        } ,
    	"tags": [
          {
            "tagName":""
          }
    	],
        "comments": [
          {
            "commentId": "",
            "writerId": "",
            "content": ""
          }   
        ]     
    }
    ```

- 업무 등록 : POST /projects/{projectId}/tasks

    ```json
    {
    	"projectName": "프로젝트명",
    	"관리자": "관리자(생성자)이름",
    	"status": "status",
    	"tag": ["태그명"]
    }
    ```

- 업무 수정 : PUT /projects/{projectId}/tasks/{id}

    ```json
    {
    	"projectName": "프로젝트명",
    	"관리자": "관리자(생성자)이름",
    	"status": "status",
    	"tag": ["태그명"]
    }
    ```

- 업무 삭제 : DELETE /projects/{projectId}/tasks/{id}

### 태그

- 태그 조회 : GET /projects/{projectId}/tasks/{taskId}/tags

    ```json
    [
    	{
    		"name": "name"
    	}
    ]
    ```

- 태그 조회 : GET /projects/{projectId}/tasks/{taskId}/tags

    ```json
    {
    	"name": "name"
    }
    ```

- 태그 등록 : POST /projects/{projectId}/tasks/{taskId}/tags
    - requset 요청

    ```json
    {
    	"name": "tag명"
    }
    ```

- 태그 수정 : PUT /projects/{projectId}/tasks/{taskId}/tags/{tagId}
    - requset 요청

    ```json
    {
    	"name": "tag명"
    }
    ```

- 태그 삭제 : DELETE /projects/{projectId}/tasks/{taskId}/tags/{tagId}

### 코멘트

- 코멘트 조회: GET /projects/{projectId}/tasks/{taskId}/comments
    - response

    ```json
    {
    	"writer": "작성자",
    	"contents": "내용"
    }
    ```

- 코멘트 등록: POST /projects/{projectId}/tasks/{taskId}/comments
    - request 요청

    ```json
    {
    	"writer": "작성자",
    	"contents" : "내용"
    }
    ```

- 코멘트 수정: PUT /projects/{projectId}/tasks/{taskId}/comments/{commentsId}
    - request

    ```json
    {
    	"contents": "내용"
    }
    ```

- 코멘트 삭제: DELETE /projects/{projectsId}/tasks/{taskId}/comments/{commentId}