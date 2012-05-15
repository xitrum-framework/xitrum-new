package quickstart

import xitrum.Controller

trait Layout extends Controller {
  override def layout = renderScalate(classOf[Layout])
}
