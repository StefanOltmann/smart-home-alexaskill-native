/*
 * Stefans Smart Home Project
 * Copyright (C) 2025 Stefan Oltmann
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package de.stefan_oltmann.smarthome.alexaskill.network

import de.stefan_oltmann.smarthome.alexaskill.model.Device
import de.stefan_oltmann.smarthome.alexaskill.model.DevicePowerState
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class DefaultRestApi(
    private val httpClient: HttpClient,
    private val baseUrl: String
) : RestApi {

    /**
     * Returns all devices for device discovery.
     */
    override suspend fun findAllDevices(): List<Device> {
        return httpClient.get("$baseUrl/devices").body()
    }

    /**
     * Turns a device (for e.g., a light) on and off.
     */
    override suspend fun setDevicePowerState(
        deviceId: String,
        powerState: DevicePowerState
    ) {
        httpClient.get("$baseUrl/device/$deviceId/set/power-state/value/$powerState")
    }

    /**
     * Sets a percentage value to a device. For example, a dimmer or a roller shutter.
     */
    override suspend fun setDevicePercentage(
        deviceId: String,
        percentage: Int
    ) {
        httpClient.get("$baseUrl/device/$deviceId/set/percentage/value/$percentage")
    }

    /**
     * Sets a target temperature value to a device. For example, heating.
     */
    override suspend fun setDeviceTargetTemperature(
        deviceId: String,
        targetTemperature: Int
    ) {
        httpClient.get("$baseUrl/device/$deviceId/set/target-temperature/value/$targetTemperature")
    }
}
