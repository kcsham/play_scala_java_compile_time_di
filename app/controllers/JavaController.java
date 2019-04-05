package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class JavaController extends Controller {


    public Result ping() {

        String msg = ctx().request().getQueryString("msg");
        return ok("Java Pong " + msg);

    }
}
