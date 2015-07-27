package com.lab49.di.circular;

import javax.inject.Inject;

interface MessageHandler {
}
 
interface RepositoryClient {
}
 
interface ServiceClient {
}
 
class MessageHandlerImpl implements MessageHandler {
 
       RepositoryClient handler;
 
       @Inject
       MessageHandlerImpl(RepositoryClient handler) {
              this.handler = handler;
       }
}
 
class RepositoryClientImpl implements RepositoryClient {
 
       ServiceClient client;
 
       @Inject
       public RepositoryClientImpl(ServiceClient client) {
              this.client = client;
       }
}
 
class ServiceClientImpl implements ServiceClient {
 
       MessageHandler handler;
 
       @Inject
       void registerHandler(MessageHandler handler) {
              this.handler = handler;
       }
}
