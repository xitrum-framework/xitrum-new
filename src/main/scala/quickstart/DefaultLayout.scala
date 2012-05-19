package quickstart

import xitrum.Controller

trait DefaultLayout extends Controller {
  override def layout = renderScalate(classOf[DefaultLayout])
}
