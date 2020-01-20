import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceForRules {
    public void findToCopyRules() {

        String rulesSource = "SYSTEM_SECURITY;SYSTEM_AGRESSO;SUPERUSER;REGISTER_FULLACCESS;PROJECT_CLOSE;PASSWORD_ADMIN;NAV_ADMIN;MENU_S_GRUPP;MENU_ADMIN_SUPPLIER;MENU_ADMIN_CUSTOMER;CONNECT_ADMIN;BOOKKEPPING_FULLACCESS;BASE_USER;ARTICLE_FULLACCESS;AGENCY_ADMIN;ADMIN_WORKTIMES;ADMIN_SITES;ADMIN_SALES;ADMIN_REGISTER;ADMIN_PUBLICMESSAGES;ADMIN_PROJECTSTATISTICS;ADMIN_PROJECT;ADMIN_PRICE;ADMIN_ORDER;ADMIN_MENU;ADMIN_INVOICEREG;ADMIN_FLIGHTSALES;ADMIN_DYNART;ADMIN_DESTINATIONCODES;ADMIN_DAILYSALES;ADMIN_COUNTRYCODES;ADMIN_COMPANYOFFICE;ADMIN_COMMONREGISTRY;ADMIN_CARRIERCODES;ADMIN_BUDGET;ADMIN_ATTACHMENTS;ADMIN_ARTICLESTATISTICS;ADMIN_ARTICLEADMIN;";
        String rulesTarget ="ADMIN_ARTICLEADMIN;ADMIN_ARTICLESTATISTICS;ADMIN_BUDGET;ADMIN_COMMONREGISTRY;ADMIN_COMPANYOFFICE;ADMIN_DAILYSALES;ADMIN_FLIGHTSALES;ADMIN_ORDER;ADMIN_PROJECT;ADMIN_PROJECTSTATISTICS;ADMIN_PUBLICMESSAGES;ADMIN_REGISTER;ADMIN_REPORT;ADMIN_SALES;ADMIN_SITES;ADMIN_WORKTIMES;ARTICLE_FULLACCESS;BOOKKEPPING_FULLACCESS;MENU_ADMIN_CUSTOMER;MENU_ADMIN_SUPPLIER;MENU_S_GRUPP;PASSWORD_ADMIN;PROJECT_CLOSE;REGISTER_FULLACCESS;SUPERUSER;SYSTEM_AGRESSO;SYSTEM_SECURITY;";

        List<String> ruleSourceWords = Arrays.asList(rulesSource.split(";"));
        List<String> ruleTargetWords = Arrays.asList(rulesTarget.split(";"));
        List<String> ruleTargetWordToAddFromSource = new ArrayList<>();

        for (String sW : ruleSourceWords){
            if (!ruleTargetWords.contains(sW)){
                ruleTargetWordToAddFromSource.add(sW);
            }
        }
        String inSctiptWords="";
        for (String aW:ruleTargetWordToAddFromSource){
            inSctiptWords += "'"+ aW + "'" +", ";
        }
        System.out.println(ruleSourceWords.get(0));

    }
    public void findToCopyCon() {

        String rulesSource = "1;2;3;4;21;22;23;25;26;5;6;7;8;10;11;12;13;14;15;17";
        String rulesTarget ="1;2;3;22;23;24;26;27;28;29;30;34;35;36;37;38;40;41;42;43;44;45;46;48;49;50;51;52;53;54;55;56;57;58;59";
        List<String> ruleSourceWords = Arrays.asList(rulesSource.split(";"));
        List<String> ruleTargetWords = Arrays.asList(rulesTarget.split(";"));
        List<String> ruleTargetWordToAddFromSource = new ArrayList<>();

        for (String sW : ruleSourceWords){
            if (!ruleTargetWords.contains(sW)){
                ruleTargetWordToAddFromSource.add(sW);
            }
        }
        String inSctiptWords="";
        for (String aW:ruleTargetWordToAddFromSource){
            inSctiptWords += aW +", ";
        }
        System.out.println(ruleSourceWords.get(0));

    }
}
