package quickstart.controller

object Site extends Site

class Site extends AppController {
  def index = GET {
    respondView()
  }
}
