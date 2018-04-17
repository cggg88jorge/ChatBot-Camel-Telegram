package com.makingdevs.routes

import com.makingdevs.config.Application
import org.apache.camel.Exchange
import org.apache.camel.LoggingLevel
import org.apache.camel.builder.RouteBuilder

class TelegramRoute extends RouteBuilder {

  ConfigObject configuration = Application.instance.configuration

  void configure(){

    errorHandler(loggingErrorHandler("com.makingdevs.filter").level(LoggingLevel.ERROR))

    from("")
      .process { Exchange e ->
        println e.in.body
        e.out.body = "Que onda a todos"
      }
      .to("")
  }
}
