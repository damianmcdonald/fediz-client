package com.github.damianmcdonald.fedizclient;

import com.github.damianmcdonald.fedizclient.service.FedizRestApi;
import com.github.damianmcdonald.fedizclient.service.FedizService;

public class App 
{

    private final FedizService fedizService = new FedizService();

    public static void main( String[] args ) throws Exception {
        App app = new App();
        app.getTrustedIdps();
        app.getApplications();
    }

    private void getTrustedIdps() throws Exception {
        fedizService.getTrustedIdps(FedizRestApi.TRUSTED_IDP).stream().forEach(e -> System.out.println(e));
    }

    private void getApplications() throws Exception {
        fedizService.getApplications(FedizRestApi.APPLICATIONS).stream().forEach(e -> System.out.println(e));
    }
}
