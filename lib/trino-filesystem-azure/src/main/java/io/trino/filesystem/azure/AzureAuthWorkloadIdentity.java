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

import com.azure.identity.WorkloadIdentityCredential;
import com.azure.identity.WorkloadIdentityCredentialBuilder;
import com.azure.storage.blob.BlobContainerClientBuilder;
import com.azure.storage.file.datalake.DataLakeServiceClientBuilder;
import com.google.inject.Inject;

public final class AzureAuthWorkloadIdentity
        implements AzureAuth
{
    private final WorkloadIdentityCredential credential;

    @Inject
    public AzureAuthWorkloadIdentity(AzureAuthWorkloadIdentityConfig config)
    {
        this(config.getTenantId(), config.getClientId(), config.getTokenPath());
    }

    public AzureAuthWorkloadIdentity(String tenantId, String clientId, String tokenPath)
    {
        credential = new WorkloadIdentityCredentialBuilder()
                .clientId(clientId)
                .tokenFilePath(tokenPath)
                .tenantId(tenantId)
                .build();
    }

    @Override
    public void setAuth(String storageAccount, BlobContainerClientBuilder builder)
    {
        builder.credential(credential);
    }

    @Override
    public void setAuth(String storageAccount, DataLakeServiceClientBuilder builder)
    {
        builder.credential(credential);
    }
}
