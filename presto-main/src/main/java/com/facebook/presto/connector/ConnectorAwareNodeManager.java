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
package com.facebook.presto.connector;

import com.facebook.presto.metadata.InternalNodeManager;
import com.facebook.presto.spi.Node;
import com.facebook.presto.spi.NodeManager;
import com.facebook.presto.spi.NodeState;

import java.util.Set;

import static java.util.Objects.requireNonNull;

public class ConnectorAwareNodeManager
        implements NodeManager
{
    private final InternalNodeManager nodeManager;

    public ConnectorAwareNodeManager(InternalNodeManager nodeManager)
    {
        this.nodeManager = requireNonNull(nodeManager, "nodeManager is null");
    }

    @Override
    public Set<Node> getNodes(NodeState state)
    {
        return nodeManager.getNodes(state);
    }

    @Override
    public Set<Node> getActiveDatasourceNodes(String datasourceName)
    {
        return nodeManager.getActiveDatasourceNodes(datasourceName);
    }

    @Override
    public Node getCurrentNode()
    {
        return nodeManager.getCurrentNode();
    }

    @Override
    public Set<Node> getCoordinators()
    {
        return nodeManager.getCoordinators();
    }
}
