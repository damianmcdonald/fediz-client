package com.github.damianmcdonald.fedizclient.service;

import com.github.damianmcdonald.fedizclient.domain.Application;
import com.github.damianmcdonald.fedizclient.domain.TrustedIdp;

import java.util.Set;

public class FedizService {

    private final FedizRestApiService restApiService = new FedizRestApiService();

    public Set<TrustedIdp> getTrustedIdps(final FedizRestApi fedizRestApi) {
        return (Set<TrustedIdp>) restApiService.getRestResponse(fedizRestApi);
    }

    public Set<Application> getApplications(final FedizRestApi fedizRestApi) {
        return (Set<Application>) restApiService.getRestResponse(fedizRestApi);
    }
}
