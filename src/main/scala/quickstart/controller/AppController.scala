package quickstart.controller

import xitrum.Controller

trait AppController extends Controller {
  override def layout = renderScalate(classOf[AppController])
}
