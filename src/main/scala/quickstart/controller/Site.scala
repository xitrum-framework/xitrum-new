package quickstart.controller

object Site extends Site

class Site extends quickstart.Layout {
  def index = GET {
    respondView()
  }
}
