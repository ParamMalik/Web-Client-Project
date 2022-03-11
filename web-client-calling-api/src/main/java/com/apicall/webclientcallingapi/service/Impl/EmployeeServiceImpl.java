package com.apicall.webclientcallingapi.service.Impl;

import com.apicall.webclientcallingapi.config.WebClientConfig;
import com.apicall.webclientcallingapi.model.EmployeeModel;
import com.apicall.webclientcallingapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private WebClient webClient;

    @Override
    public Flux<EmployeeModel> findAll() {

        return webClient.get().uri("/find").retrieve().bodyToFlux(EmployeeModel.class);
    }

    @Override
    public Mono<EmployeeModel> findById(String id) {
        return webClient.get().uri("/find/{id}", id).retrieve().bodyToMono(EmployeeModel.class);
    }

    @Override
    public Mono<EmployeeModel> saveEmpDetails(EmployeeModel employeeModel) {

        return webClient.post()
                .uri("/save")
                .bodyValue(employeeModel)
                .retrieve().bodyToMono(EmployeeModel.class);
    }

    @Override
    public Mono<EmployeeModel> updateEmpDetails(EmployeeModel employeeModel) {

        return webClient.put().uri("/update")
                .bodyValue(employeeModel)
                .retrieve().bodyToMono(EmployeeModel.class)
                ;
    }

    @Override
    public Mono<Void> deleteEmpDetails(String id) {
        return webClient.delete()
                .uri("/delete/{id}", id)
                .retrieve()
                .bodyToMono(Void.class);
    }


}
