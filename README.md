#Spring cloud connector for gemfire

## Intro

This is an extension to the [spring service connectors](https://github.com/spring-cloud/spring-cloud-connectors/tree/master/spring-cloud-spring-service-connector) that provides a [gemfire client cache](http://gemfire.docs.pivotal.io/latest/userguide/index.html#basic_config/the_cache/managing_a_client_cache.html) as a managed spring bean once you bound a gemfire service to it.

## Using

The service expects a gemfire service with the following format:

```javascript
{
"p-gemfire":[
{
"name":"gemfire1",
"label":"p-gemfire",
"tags":[
"gemfire",
"session_replication"
],
"plan":"PlanNameGoesHere",
"credentials":{
"locators":[
"10.0.0.57[55221]",
"10.0.0.58[55221]"
],
"username":"cd390983-01db-4dcf-75fd-79289d4fdbcd",
"password":"13917597139205230931"
}
}
]
}

```


