package controllers

import javax.inject.Inject
import play.api.mvc.{BaseController, ControllerComponents}

class ScalaController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def ping(msg: String) = Action {
    Ok(s"Scala Pong $msg")
  }
}
