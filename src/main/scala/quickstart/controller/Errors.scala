package quickstart.controller

import xitrum.ErrorController

class Errors extends AppController with ErrorController {
  def error404 = errorAction {
    respondView()
  }

  def error500 = errorAction {
    respondView()
  }
}
