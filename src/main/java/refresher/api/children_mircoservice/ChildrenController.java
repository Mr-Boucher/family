package refresher.api.children_mircoservice;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import refresher.api.common.Controller;
import refresher.model.Person;
import refresher.util.Page;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 1)
public class ChildrenController extends Controller
{
  @GetMapping("/readChildrenOfFather")
  public Page<Person> readChildrenOfFather() throws Exception
  {
    return new Logic().readChildrenWithFather();
  }
}
