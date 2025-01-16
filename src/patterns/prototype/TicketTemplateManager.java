package patterns.prototype;

import java.util.HashMap;
import java.util.Map;

public class TicketTemplateManager {
    private Map<String, TicketTemplate> templates = new HashMap<>();

    public void addTemplate(String templateName, TicketTemplate template) {
        templates.put(templateName, template);
    }

    public TicketTemplate getTemplate(String templateName) {
        TicketTemplate template = templates.get(templateName);
        if (template == null) {
            throw new IllegalArgumentException("Template not found: " + templateName);
        }
        return template.clone();
    }
}
