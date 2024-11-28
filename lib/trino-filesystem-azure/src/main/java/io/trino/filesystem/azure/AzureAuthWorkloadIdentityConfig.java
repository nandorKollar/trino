/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.trino.filesystem.azure;

import io.airlift.configuration.Config;
import jakarta.validation.constraints.NotEmpty;

public class AzureAuthWorkloadIdentityConfig
{
    private String tenantId;
    private String clientId;
    private String tokenPath;

    @NotEmpty
    public String getTenantId()
    {
        return tenantId;
    }

    @NotEmpty
    public String getClientId()
    {
        return clientId;
    }

    @NotEmpty
    public String getTokenPath()
    {
        return tokenPath;
    }

    @Config("azure.workloadidentity.tenant-id")
    public AzureAuthWorkloadIdentityConfig setTenantId(String tenantId)
    {
        this.tenantId = tenantId;
        return this;
    }

    @Config("azure.workloadidentity.client-id")
    public AzureAuthWorkloadIdentityConfig setClientId(String clientId)
    {
        this.clientId = clientId;
        return this;
    }

    @Config("azure.workloadidentity.token-path")
    public AzureAuthWorkloadIdentityConfig setTokenPath(String tokenPath)
    {
        this.tokenPath = tokenPath;
        return this;
    }
}
