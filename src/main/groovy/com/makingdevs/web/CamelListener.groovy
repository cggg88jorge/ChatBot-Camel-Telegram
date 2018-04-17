package com.makingdevs.web


import com.makingdevs.routes.TelegramRoute
import org.apache.camel.CamelContext
import org.apache.camel.impl.DefaultCamelContext

import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener

class CamelListener implements ServletContextListener {

  CamelContext camelContext = new DefaultCamelContext()

  void contextInitialized(ServletContextEvent sce) {
    camelContext.addRoutes(new TelegramRoute())
    camelContext.start()
  }

  void contextDestroyed(ServletContextEvent sce) {
    camelContext.stop()
  }
}

