package com.example.cms;

public class questions {
    public String[] thequestions= {
            "Do you have a cough?",
            "Do you have  cold?",
            "Are you having diarrhea?",
            "Are you experiencing body aches?",
            "Do yo have a headache?",
            "Do you have fever?",
            "Are you having difficulty breathing?",
            "Do you sore throat?",
            "Are you experiencing  fatigue?",
            "Have you travelled recently for past 14 days?",
            "Do you have a travel history to covid 19 infected area?",
            "please click the finish button"

    };
    private String choices[][]={

            {"yes","no"},
            {"yes","no"},
            {"yes","no"},
            {"yes","no"},
            {"yes","no"},
            {"yes","no"},
            {"yes","no"},
            {"yes","no"},
            {"yes","no"},
            {"yes","no"},
            {"yes","no"},
            {"--","--"}


    };

    public String getquestion(int a) {
        String question = thequestions[a];
        return question;
    }

    public String getchoice1(int a){
        String choice1 =choices[a][0];
        return choice1;
    }

    public String getchoice2(int a){
        String choice2 =choices[a][1];
        return choice2;
    }
}
