# Dojo
This is a project demonstrates the use of configuration service deployed to Pivotal Cloud Foundry

## Test REST API Call
| Resource        | Method           | Description  |
| --- | --- | --- |
| `/techniques` | GET | Queries the list of techniques.  Returned set should change based on passed profile - either judo, or jiu-jitsu. |
| `/env` | GET | Queries the environment of the app.  Data under configService nodes served by config server. |

## Configuration Server
Configuration Service instance must be created in PCF and configured to point to Training Grounds configuration files in [github](https://github.com/poprygun/training-grounds-config)
```
$ cf login -u <username> -p <password> -a https://api.run.pez.pivotal.io
$ cf target -o <organization> -s <space>

```
Make sure that p-config-server is listed in marketplace using
```
$ cf marketplace
```
Create a service associated with the [repository](https://github.com/poprygun/training-grounds-config) hosting configuration files
```
$ cf create-service -c '{ "git": { "uri": "https://github.com/poprygun/training-grounds-config", "label": "master" } }' p-config-server standard config-server
```
Add the certificate using Spring Cloud Services
```
cf set-env training-grounds CF_TARGET https://ashumilov-tg.cfapps.pez.pivotal.io
```

manifest.yml file should list profiles used to run the application
```
  env:
    SPRING_PROFILES_ACTIVE: judo,dev
```    
Application can be started locally for testing purposes in tandem wtih configuration server.  Profiles used by the application can be controlled using program parameters --spring.profiles.active=dev,judo
Current configuration of the application can be viewed 
## Resources
* [Cloud Services Documentation] (http://docs.pivotal.io/spring-cloud-services/)
* [PCF Configuration Server Service] (http://docs.pivotal.io/spring-cloud-services/config-server/)
