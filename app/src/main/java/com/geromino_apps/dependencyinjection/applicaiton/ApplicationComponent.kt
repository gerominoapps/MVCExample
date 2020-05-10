package com.geromino_apps.dependencyinjection.applicaiton

import com.geromino_apps.data.gateway.quotes.QueryGateWay
import com.geromino_apps.dependencyinjection.domain.DomainModule
import com.geromino_apps.dependencyinjection.presentation.PresentationComponent
import com.geromino_apps.dependencyinjection.presentation.PresentationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, DomainModule::class])
interface ApplicationComponent {
    fun newPresentationComponent(module: PresentationModule): PresentationComponent
    fun inject(quptesGateWay: QueryGateWay)
}