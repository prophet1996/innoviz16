package innoviz.ieee.niec.com.innoviz16.Frags;

/**
 * Created by PROPHET on 07-03-2016.
 */
public class DataProvider {
    public DataProvider(int img_res,String e_name,String e_desc){
        this.setE_desc(e_desc);
        this.setE_name(e_name);
        this.setImg_res(img_res);
    }
    private int img_res;
    private String e_name;
            private String e_desc;

    public int getImg_res() {
        return img_res;
    }

    public void setImg_res(int img_res) {
        this.img_res = img_res;
    }

    public String getE_desc() {
        return e_desc;
    }

    public void setE_desc(String e_desc) {
        this.e_desc = e_desc;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }
}
