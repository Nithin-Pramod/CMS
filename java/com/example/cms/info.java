package com.example.cms;

public class info {
    public String[] textinfo = {
            "---May be stress related and observe--- ",
            "---Hydrate properly and maintain proper personel hygiene. observe and reevaluate after two days---",
            "---Seek a consultation with doctor---",
            "---Call the DOH hotline- 0286517800---",
            "---error---"

    };

    public String gettext(int a) {
        if (a > 0 && a < 3) {
            String info = textinfo[0];
            return info;
        } else if (a > 3 && a < 6) {
            String info = textinfo[1];
            return info;
        } else if (a > 6 && a < 9) {
            String info = textinfo[2];
            return info;
        } else if (a > 9 && a < 13) {
            String info = textinfo[3];
            return info;
        } else {
            String info = textinfo[4];
            return info;
        }
    }
}
