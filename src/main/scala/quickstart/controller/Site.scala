package quickstart.controller

import quickstart.DefaultLayout

object Site extends Site

class Site extends DefaultLayout {
  def index = GET {
    respondView()
  }
}
