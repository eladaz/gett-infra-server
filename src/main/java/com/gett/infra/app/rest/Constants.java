package com.gett.infra.app.rest;

public interface Constants {

        interface Rest {

            String INDEX = "/";
            String HOME = "/home";
            String API = "/api";

            String VERSION = "version";
            String LOGS = "logs";
            String ID = "id";

            String PARAM_START = "{";
            String PARAM_END = "}";


            String ENTITIES = "entities";

            String ENTITY_ID = "/" +
                    PARAM_START +
                    ID +
                    PARAM_END;


            String CREDIT_CARD = "credit_card";
            String CREDIT_CARDS = "credit_cardS";




            String PERFECTO_DEVICE = "perfecto_device";
            String PHONE_NUMBER = "phone_number";

//            String NAME = "test-name";
//            String NAMES = "tests-name";
//            String STATISTICS = "/statistics";

//            String ARRAY_START = "[";
//            String ARRAY_END = "]";
//            String TEST_NAME = "/" +
//                    PARAM_START +
//                    NAME +
//                    PARAM_END;
//            String TEST_BULK = "/" +
//                    PARAM_START +
//                    NAMES +
//                    PARAM_END;
        }

}



