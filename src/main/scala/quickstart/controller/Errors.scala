package quickstart.controller

import xitrum.ErrorController
import quickstart.DefaultLayout

class Errors extends DefaultLayout with ErrorController {
  def error404 = errorAction {
    respondView()
  }

  def error500 = errorAction {
    respondView()
  }
}
