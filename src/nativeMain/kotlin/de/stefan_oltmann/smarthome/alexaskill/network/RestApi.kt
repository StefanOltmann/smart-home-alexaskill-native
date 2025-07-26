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

interface RestApi {

    /**
     * Returns all devices for device discovery.
     */
    suspend fun findAllDevices(): List<Device>

    /**
     * Turns a device (for e.g., a light) on and off.
     */
    suspend fun setDevicePowerState(
        deviceId: String,
        powerState: DevicePowerState
    )

    /**
     * Sets a percentage value to a device. For example, a dimmer or a roller shutter.
     */
    suspend fun setDevicePercentage(
        deviceId: String,
        percentage: Int
    )

    /**
     * Sets a target temperature value to a device. For example, heating.
     */
    suspend fun setDeviceTargetTemperature(
        deviceId: String,
        targetTemperature: Int
    )

}
