/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.server.audio;

import android.annotation.NonNull;
import android.media.AudioDeviceAttributes;
import android.media.AudioSystem;

import java.util.List;

/**
 * Provides an adapter to access functionality of the android.media.AudioSystem class for device
 * related functionality.
 * Use the "real" AudioSystem through the default adapter.
 * Use the "always ok" adapter to avoid dealing with the APM behaviors during a test.
 */
public class AudioSystemAdapter {

    /**
     * Create a wrapper around the {@link AudioSystem} static methods, all functions are directly
     * forwarded to the AudioSystem class.
     * @return an adapter around AudioSystem
     */
    static final @NonNull AudioSystemAdapter getDefaultAdapter() {
        return new AudioSystemAdapter();
    }

    /**
     * Same as {@link AudioSystem#setDeviceConnectionState(int, int, String, String, int)}
     * @param device
     * @param state
     * @param deviceAddress
     * @param deviceName
     * @param codecFormat
     * @return
     */
    public int setDeviceConnectionState(int device, int state, String deviceAddress,
                                        String deviceName, int codecFormat) {
        return AudioSystem.setDeviceConnectionState(device, state, deviceAddress, deviceName,
                codecFormat);
    }

    /**
     * Same as {@link AudioSystem#getDeviceConnectionState(int, String)}
     * @param device
     * @param deviceAddress
     * @return
     */
    public int getDeviceConnectionState(int device, String deviceAddress) {
        return AudioSystem.getDeviceConnectionState(device, deviceAddress);
    }

    /**
     * Same as {@link AudioSystem#handleDeviceConfigChange(int, String, String, int)}
     * @param device
     * @param deviceAddress
     * @param deviceName
     * @param codecFormat
     * @return
     */
    public int handleDeviceConfigChange(int device, String deviceAddress,
                                               String deviceName, int codecFormat) {
        return AudioSystem.handleDeviceConfigChange(device, deviceAddress, deviceName,
                codecFormat);
    }

    /**
     * Same as {@link AudioSystem#setDevicesRoleForStrategy(int, int, List)}
     * @param strategy
     * @param role
     * @param devices
     * @return
     */
    public int setDevicesRoleForStrategy(int strategy, int role,
                                         @NonNull List<AudioDeviceAttributes> devices) {
        return AudioSystem.setDevicesRoleForStrategy(strategy, role, devices);
    }

    /**
     * Same as {@link AudioSystem#removeDevicesRoleForStrategy(int, int)}
     * @param strategy
     * @param role
     * @return
     */
    public int removeDevicesRoleForStrategy(int strategy, int role) {
        return AudioSystem.removeDevicesRoleForStrategy(strategy, role);
    }

    /**
     * Same as (@link AudioSystem#setDevicesRoleForCapturePreset(int, List))
     * @param capturePreset
     * @param role
     * @param devices
     * @return
     */
    public int setDevicesRoleForCapturePreset(int capturePreset, int role,
                                              @NonNull List<AudioDeviceAttributes> devices) {
        return AudioSystem.setDevicesRoleForCapturePreset(capturePreset, role, devices);
    }

    /**
     * Same as {@link AudioSystem#removeDevicesRoleForCapturePreset(int, int)}
     * @param capturePreset
     * @param role
     * @param devicesToRemove
     * @return
     */
    public int removeDevicesRoleForCapturePreset(
            int capturePreset, int role, @NonNull List<AudioDeviceAttributes> devicesToRemove) {
        return AudioSystem.removeDevicesRoleForCapturePreset(capturePreset, role, devicesToRemove);
    }

    /**
     * Same as {@link AudioSystem#}
     * @param capturePreset
     * @param role
     * @return
     */
    public int clearDevicesRoleForCapturePreset(int capturePreset, int role) {
        return AudioSystem.clearDevicesRoleForCapturePreset(capturePreset, role);
    }

    /**
     * Same as {@link AudioSystem#setParameters(String)}
     * @param keyValuePairs
     * @return
     */
    public int setParameters(String keyValuePairs) {
        return AudioSystem.setParameters(keyValuePairs);
    }

    /**
     * Same as {@link AudioSystem#isMicrophoneMuted()}}
     * Checks whether the microphone mute is on or off.
     * @return true if microphone is muted, false if it's not
     */
    public boolean isMicrophoneMuted() {
        return AudioSystem.isMicrophoneMuted();
    }

    /**
     * Same as {@link AudioSystem#muteMicrophone(boolean)}
     * Sets the microphone mute on or off.
     *
     * @param on set <var>true</var> to mute the microphone;
     *           <var>false</var> to turn mute off
     * @return command completion status see AUDIO_STATUS_OK, see AUDIO_STATUS_ERROR
     */
    public int muteMicrophone(boolean on) {
        return AudioSystem.muteMicrophone(on);
    }

    /**
     * Same as {@link AudioSystem#setCurrentImeUid(int)}
     * Communicate UID of current InputMethodService to audio policy service.
     */
    public int setCurrentImeUid(int uid) {
        return AudioSystem.setCurrentImeUid(uid);
    }

    /**
     * Same as {@link AudioSystem#isStreamActive(int, int)}
     */
    public boolean isStreamActive(int stream, int inPastMs) {
        return AudioSystem.isStreamActive(stream, inPastMs);
    }
}
