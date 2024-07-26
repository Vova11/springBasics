package com.example.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionongPersonController {
    // URI versioning
    @GetMapping("/v1/person")
    public PersonV1 getVersionV1OfPerson() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 getVersionV2OfPerson() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // Request Param versioning
    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getVersion1OfPersonRequestParamteters() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getVersion2OfPersonRequestParamteters() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // Custom headers versioning
    @GetMapping(path = "/person", headers = "X-API-VERSION=1")
    public PersonV1 getVersion1OfPersonRequestHeader() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person", headers = "X-API-VERSION=2")
    public PersonV2 getVersion2OfPersonRequestHeader() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    //Media type versioning
    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getVersion1OfPersonAcceptHeader() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getVersion2OfPersonAcceptHeader() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
