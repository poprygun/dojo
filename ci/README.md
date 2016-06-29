Concourse CI
============

Sample showing the definition of a simple concourse pipeline defining maven build and deployment to CF Pez environment.

##To setup a local concourse instance using vagrant
~~~
$ vagrant init concourse/lite
$ vagrant up
~~~

##To configure and depoy a pipeline
~~~
$ fly -t dojo-target login -c http://192.168.100.4:8080
$ fly -t dojo-target set-pipeline -c ci/dojo.yml -p dojo-pipeline -l ci/credentials.yml
~~~
Contents of credentials.yml file should containg a replacement tokens for placeholders defined in pipeline definition - dojo.yml and formatted as
~~~
api-username: (my username)
api-password: (my password)
~~~
Pipeline will be available in [UI of local concourse installation](http://192.168.100.4:8080/pipelines/dojo-pipeline)




