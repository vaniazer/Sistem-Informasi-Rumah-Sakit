package utama;

import controller_pack.*;
import view_pack.*;

public class MVC {
    public MVC(){
        vLogin vLogin = new vLogin();
        Model model = new Model();
        Controller controller = new Controller(vLogin,model);
    }
}
