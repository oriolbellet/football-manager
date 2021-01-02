package org.oriolbellet.football.configuration;

import io.dekorate.kubernetes.annotation.Env;
import io.dekorate.kubernetes.annotation.KubernetesApplication;
import io.dekorate.kubernetes.annotation.Port;

@KubernetesApplication(
        envVars = { @Env(name = "SPRING_RABBITMQ_HOST", value = "rabbitmq-cluster-ip-service")},
        ports = { @Port(name = "http", containerPort = 8080) }
        )
public class DekorateConfig {}
