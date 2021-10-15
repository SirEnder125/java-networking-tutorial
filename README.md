# NetworkingTutorial
This tutorial shows how to make a server and client and send information between the two using the Java programming language.

## What's included
Well, nothing right now besides the source code. I'll probably add a tutorial in the wiki some time.

## Source
```
io/github/sirender125/networkingtutorial
|
+---server
|    Server.java
|    ClientHandler.java
+---client
     Client.java
```

## Q&A:
**Q: I accidentally entered the wrong command on the client, and now it is not asking me for input! What happened?**<br/>
A: This is because the server does not respond to invalid requests, so the client just keeps waiting for a response. This has been fixed in recent commits.
