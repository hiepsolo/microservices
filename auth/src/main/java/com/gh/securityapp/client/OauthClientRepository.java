package com.gh.securityapp.client;

import com.gh.securityapp.client.entities.OauthClientDetailsEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OauthClientRepository extends PagingAndSortingRepository<OauthClientDetailsEntity, String> {
}
