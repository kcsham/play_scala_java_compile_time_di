import controllers.{AssetsComponents, JavaController, ScalaController}
import play.api.ApplicationLoader.Context
import play.api.routing.Router
import play.api.{Application, ApplicationLoader, BuiltInComponentsFromContext, LoggerConfigurator}
import play.filters.HttpFiltersComponents
import router.Routes

class MyApplicationLoader extends ApplicationLoader {
  override def load(context: Context): Application = {
    LoggerConfigurator(context.environment.classLoader).foreach {
      _.configure(context.environment, context.initialConfiguration, Map.empty)
    }

    new MyComponents(context).application
  }
}


class MyComponents(context: Context)
  extends BuiltInComponentsFromContext(context)
    with HttpFiltersComponents
    with AssetsComponents {

  val scalaController = new ScalaController(controllerComponents)
  val javaController = new JavaController()


  override def router: Router = {
    new Routes(
      httpErrorHandler,
      scalaController,
      javaController,
      assets,
      prefix = "/")
  }

}
