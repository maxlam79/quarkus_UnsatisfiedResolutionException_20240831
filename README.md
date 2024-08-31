# A reproduction of the issue in Quarkus 3.14.1

## Use MariaDB and create a table:
```
create table t_investigate
(
    uuid char(32) not null,
    primary key(uuid)
);
```

## Error log:
```
2024-08-31 16:49:46,566 ERROR [io.qua.dep.dev.IsolatedDevModeMain] (main) Failed to start quarkus: java.lang.RuntimeException: io.quarkus.builder.BuildException: Build failure: Build failed due to errors
        [error]: Build step io.quarkus.arc.deployment.ArcProcessor#validate threw an exception: jakarta.enterprise.inject.spi.DeploymentException: jakarta.enterprise.inject.UnsatisfiedResolutionException: Unsatisfied dependency for type org.hibernate.reactive.mutiny.Mutiny$Session and qualifiers [@Default]
        - injection target: my.cloudlegato.InvestigateProcess#em
        - declared on CLASS bean [types=[my.cloudlegato.InvestigateProcess, java.lang.Object], qualifiers=[@Default, @Any], target=my.cloudlegato.InvestigateProcess]
        at io.quarkus.arc.processor.BeanDeployment.processErrors(BeanDeployment.java:1551)
        at io.quarkus.arc.processor.BeanDeployment.init(BeanDeployment.java:338)
        at io.quarkus.arc.processor.BeanProcessor.initialize(BeanProcessor.java:167)
        at io.quarkus.arc.deployment.ArcProcessor.validate(ArcProcessor.java:490)
        at java.base/java.lang.invoke.MethodHandle.invokeWithArguments(MethodHandle.java:733)
        at io.quarkus.deployment.ExtensionLoader$3.execute(ExtensionLoader.java:854)
        at io.quarkus.builder.BuildContext.run(BuildContext.java:256)
        at org.jboss.threads.ContextHandler$1.runWith(ContextHandler.java:18)
        at org.jboss.threads.EnhancedQueueExecutor$Task.doRunWith(EnhancedQueueExecutor.java:2516)
        at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2495)
        at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1521)
        at java.base/java.lang.Thread.run(Thread.java:1583)
        at org.jboss.threads.JBossThread.run(JBossThread.java:483)
Caused by: jakarta.enterprise.inject.UnsatisfiedResolutionException: Unsatisfied dependency for type org.hibernate.reactive.mutiny.Mutiny$Session and qualifiers [@Default]
        - injection target: my.cloudlegato.InvestigateProcess#em
        - declared on CLASS bean [types=[my.cloudlegato.InvestigateProcess, java.lang.Object], qualifiers=[@Default, @Any], target=my.cloudlegato.InvestigateProcess]
        at io.quarkus.arc.processor.Beans.resolveInjectionPoint(Beans.java:545)
        at io.quarkus.arc.processor.BeanInfo.init(BeanInfo.java:667)
        at io.quarkus.arc.processor.BeanDeployment.init(BeanDeployment.java:323)
        ... 11 more

        at io.quarkus.runner.bootstrap.AugmentActionImpl.runAugment(AugmentActionImpl.java:335)
        at io.quarkus.runner.bootstrap.AugmentActionImpl.createInitialRuntimeApplication(AugmentActionImpl.java:254)
        at io.quarkus.runner.bootstrap.AugmentActionImpl.createInitialRuntimeApplication(AugmentActionImpl.java:58)
        at io.quarkus.deployment.dev.IsolatedDevModeMain.firstStart(IsolatedDevModeMain.java:91)
        at io.quarkus.deployment.dev.IsolatedDevModeMain.accept(IsolatedDevModeMain.java:430)
        at io.quarkus.deployment.dev.IsolatedDevModeMain.accept(IsolatedDevModeMain.java:57)
        at io.quarkus.bootstrap.app.CuratedApplication.runInCl(CuratedApplication.java:138)
        at io.quarkus.bootstrap.app.CuratedApplication.runInAugmentClassLoader(CuratedApplication.java:93)
        at io.quarkus.deployment.dev.DevModeMain.start(DevModeMain.java:131)
        at io.quarkus.deployment.dev.DevModeMain.main(DevModeMain.java:62)
Caused by: io.quarkus.builder.BuildException: Build failure: Build failed due to errors
        [error]: Build step io.quarkus.arc.deployment.ArcProcessor#validate threw an exception: jakarta.enterprise.inject.spi.DeploymentException: jakarta.enterprise.inject.UnsatisfiedResolutionException: Unsatisfied dependency for type org.hibernate.reactive.mutiny.Mutiny$Session and qualifiers [@Default]
        - injection target: my.cloudlegato.InvestigateProcess#em
        - declared on CLASS bean [types=[my.cloudlegato.InvestigateProcess, java.lang.Object], qualifiers=[@Default, @Any], target=my.cloudlegato.InvestigateProcess]
        at io.quarkus.arc.processor.BeanDeployment.processErrors(BeanDeployment.java:1551)
        at io.quarkus.arc.processor.BeanDeployment.init(BeanDeployment.java:338)
        at io.quarkus.arc.processor.BeanProcessor.initialize(BeanProcessor.java:167)
        at io.quarkus.arc.deployment.ArcProcessor.validate(ArcProcessor.java:490)
        at java.base/java.lang.invoke.MethodHandle.invokeWithArguments(MethodHandle.java:733)
        at io.quarkus.deployment.ExtensionLoader$3.execute(ExtensionLoader.java:854)
        at io.quarkus.builder.BuildContext.run(BuildContext.java:256)
        at org.jboss.threads.ContextHandler$1.runWith(ContextHandler.java:18)
        at org.jboss.threads.EnhancedQueueExecutor$Task.doRunWith(EnhancedQueueExecutor.java:2516)
        at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2495)
        at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1521)
        at java.base/java.lang.Thread.run(Thread.java:1583)
        at org.jboss.threads.JBossThread.run(JBossThread.java:483)
Caused by: jakarta.enterprise.inject.UnsatisfiedResolutionException: Unsatisfied dependency for type org.hibernate.reactive.mutiny.Mutiny$Session and qualifiers [@Default]
        - injection target: my.cloudlegato.InvestigateProcess#em
        - declared on CLASS bean [types=[my.cloudlegato.InvestigateProcess, java.lang.Object], qualifiers=[@Default, @Any], target=my.cloudlegato.InvestigateProcess]
        at io.quarkus.arc.processor.Beans.resolveInjectionPoint(Beans.java:545)
        at io.quarkus.arc.processor.BeanInfo.init(BeanInfo.java:667)
        at io.quarkus.arc.processor.BeanDeployment.init(BeanDeployment.java:323)
        ... 11 more

        at io.quarkus.builder.Execution.run(Execution.java:123)
        at io.quarkus.builder.BuildExecutionBuilder.execute(BuildExecutionBuilder.java:79)
        at io.quarkus.deployment.QuarkusAugmentor.run(QuarkusAugmentor.java:159)
        at io.quarkus.runner.bootstrap.AugmentActionImpl.runAugment(AugmentActionImpl.java:331)
        ... 9 more
Caused by: jakarta.enterprise.inject.spi.DeploymentException: jakarta.enterprise.inject.UnsatisfiedResolutionException: Unsatisfied dependency for type org.hibernate.reactive.mutiny.Mutiny$Session and qualifiers [@Default]
        - injection target: my.cloudlegato.InvestigateProcess#em
        - declared on CLASS bean [types=[my.cloudlegato.InvestigateProcess, java.lang.Object], qualifiers=[@Default, @Any], target=my.cloudlegato.InvestigateProcess]
        at io.quarkus.arc.processor.BeanDeployment.processErrors(BeanDeployment.java:1551)
        at io.quarkus.arc.processor.BeanDeployment.init(BeanDeployment.java:338)
        at io.quarkus.arc.processor.BeanProcessor.initialize(BeanProcessor.java:167)
        at io.quarkus.arc.deployment.ArcProcessor.validate(ArcProcessor.java:490)
        at java.base/java.lang.invoke.MethodHandle.invokeWithArguments(MethodHandle.java:733)
        at io.quarkus.deployment.ExtensionLoader$3.execute(ExtensionLoader.java:854)
        at io.quarkus.builder.BuildContext.run(BuildContext.java:256)
        at org.jboss.threads.ContextHandler$1.runWith(ContextHandler.java:18)
        at org.jboss.threads.EnhancedQueueExecutor$Task.doRunWith(EnhancedQueueExecutor.java:2516)
        at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2495)
        at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1521)
        at java.base/java.lang.Thread.run(Thread.java:1583)
        at org.jboss.threads.JBossThread.run(JBossThread.java:483)
Caused by: jakarta.enterprise.inject.UnsatisfiedResolutionException: Unsatisfied dependency for type org.hibernate.reactive.mutiny.Mutiny$Session and qualifiers [@Default]
        - injection target: my.cloudlegato.InvestigateProcess#em
        - declared on CLASS bean [types=[my.cloudlegato.InvestigateProcess, java.lang.Object], qualifiers=[@Default, @Any], target=my.cloudlegato.InvestigateProcess]
        at io.quarkus.arc.processor.Beans.resolveInjectionPoint(Beans.java:545)
        at io.quarkus.arc.processor.BeanInfo.init(BeanInfo.java:667)
        at io.quarkus.arc.processor.BeanDeployment.init(BeanDeployment.java:323)
        ... 11 more
```