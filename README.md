# The application consist of Websockets ,Redis Pub Sub Pattern and Spring boot.

How to run:

Clean and build the application.
Run the application.

Use https://bkjam.github.io/websocket-debug-tool/

To connect with websocket server at /stomp .

connect to ws://localhost:8080/stomp

subscribe to /topic/toast

Logs:
_INFO_:Connect STOMP server success, url = ws://localhost:8080/stomp, connectHeader = 
$ _INFO_:subscribe destination /topic/toast success
$ _INFO_:Receive subscribed message from destination /topic/toast, content = MESSAGE
content-length:20
message-id:5695213f-e458-3fa3-0a9f-7cda9483c212-0
subscription:sub-0
content-type:text/plain;charset=UTF-8
destination:/topic/toast
content-length:20

