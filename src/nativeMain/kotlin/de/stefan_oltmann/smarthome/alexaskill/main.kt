package de.stefan_oltmann.smarthome.alexaskill

import io.github.trueangle.knative.lambda.runtime.LambdaRuntime

fun main() = LambdaRuntime.run { AlexaHandler() }