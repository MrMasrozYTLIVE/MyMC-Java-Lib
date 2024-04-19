# Library for my-mc.link api
Just a simple library that lets you work with my-mc.link API

JavaScript version of the library: https://github.com/MrMasrozYTLIVE/MyMC-Lib

How to use:
```java
import net.mitask.MyMCLib;

MyMCLib myMcLink = new MyMCLib("API_KEY_HERE");

// Will print information about API key expiration date
console.log(myMcLink.getTime().toString()); 

// Will start the server
myMcLink.startServer();
```

Credits for just cool & fun service as my-mc.link goes to SNXRaven
