import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      //model.put("members", request.session().attribute("members"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("members/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/member-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/members", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("members", Member.all());
      model.put("template", "templates/members.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/members", (request,response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String memberName = request.queryParams("memberName");
      Member newMember = new Member(memberName);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/members/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Member member = Member.find(Integer.parseInt(request.params(":id")));
      model.put("member", member);
      model.put("template", "templates/member.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }
}
