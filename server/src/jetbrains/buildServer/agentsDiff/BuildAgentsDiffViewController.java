/*
 * Copyright 2000-2014 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jetbrains.buildServer.agentsDiff;

import jetbrains.buildServer.controllers.BaseFormXmlController;
import jetbrains.buildServer.serverSide.SBuildServer;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import jetbrains.buildServer.web.openapi.WebControllerManager;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Evgeniy.Koshkin
 */
public class BuildAgentsDiffViewController extends BaseFormXmlController {

  @NotNull
  private final PluginDescriptor myPluginDescriptor;

  public BuildAgentsDiffViewController(@NotNull SBuildServer server, @NotNull PluginDescriptor pluginDescriptor, @NotNull WebControllerManager webControllerManager) {
    super(server);
    myPluginDescriptor = pluginDescriptor;
    webControllerManager.registerController("/agents/agentsDiffView.html", this);
  }

  @Override
  protected ModelAndView doGet(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) {
    final ModelAndView view = new ModelAndView(myPluginDescriptor.getPluginResourcesPath("/agentsDiffView.jsp"));
    view.getModel().put("agentA", "A");
    view.getModel().put("agentB", "B");
    return view;
  }

  @Override
  protected void doPost(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Element xmlResponse) {
  }
}
