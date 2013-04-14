package quickstart.action

import xitrum.annotation.{Error404, Error500}

@Error404
class NotFoundError extends DefaultLayout {
  def execute() {
    respondView()
  }
}

@Error500
class ServerError extends DefaultLayout {
  def execute() {
    respondView()
  }
}
