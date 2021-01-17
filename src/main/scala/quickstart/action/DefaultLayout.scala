package quickstart.action

import xitrum.Action

trait DefaultLayout extends Action {
  override def layout: String = renderViewNoLayout[DefaultLayout]()
}
