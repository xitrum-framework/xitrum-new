package quickstart

import xitrum.handler.Server
import xitrum.routing.Routes

import quickstart.controller.Errors

object Boot {
  def main(args: Array[String]) {
    Routes.error = classOf[Errors]
    Server.start()
  }
}
