/*******************************************************************************************************
 * Continued by PikaMug (formerly HappyPikachu) with permission from _Blackvein_. All rights reserved.
 * 
 * THIS SOFTWARE IS PROVIDED "AS IS" AND ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN
 * NO EVENT SHALL THE REGENTS OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY
 * OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *******************************************************************************************************/

package me.blackvein.quests.convo.quests.objectives;

import java.util.LinkedList;
import java.util.List;

import me.blackvein.quests.convo.quests.QuestsEditorNumericPrompt;
import me.blackvein.quests.convo.quests.QuestsEditorStringPrompt;
import me.blackvein.quests.convo.quests.stages.StageMainPrompt;
import me.blackvein.quests.events.editor.quests.QuestsEditorPostOpenNumericPromptEvent;
import me.blackvein.quests.events.editor.quests.QuestsEditorPostOpenStringPromptEvent;
import me.blackvein.quests.util.CK;
import me.blackvein.quests.util.ItemUtil;
import me.blackvein.quests.util.Lang;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;

public class BlocksPrompt extends QuestsEditorNumericPrompt {
    private final int stageNum;
    private final String pref;

    public BlocksPrompt(int stageNum, ConversationContext context) {
        super(context);
        this.stageNum = stageNum;
        this.pref = "stage" + stageNum;
    }
    
    private final int size = 6;
    
    public int getSize() {
        return size;
    }
    
    public String getTitle(ConversationContext context) {
        return Lang.get("stageEditorBlocks");
    }
    
    public ChatColor getNumberColor(ConversationContext context, int number) {
        switch (number) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return ChatColor.BLUE;
            case 6:
                return ChatColor.GREEN;
            default:
                return null;
        }
    }
    
    public String getSelectionText(ConversationContext context, int number) {
        switch(number) {
        case 1:
            return ChatColor.YELLOW + Lang.get("stageEditorBreakBlocks");
        case 2:
            return ChatColor.YELLOW + Lang.get("stageEditorDamageBlocks");
        case 3:
            return ChatColor.YELLOW + Lang.get("stageEditorPlaceBlocks");
        case 4:
            return ChatColor.YELLOW + Lang.get("stageEditorUseBlocks");
        case 5:
            return ChatColor.YELLOW + Lang.get("stageEditorCutBlocks");
        case 6:
            return ChatColor.GREEN + Lang.get("done");
        default:
            return null;
        }
    }
    
    @SuppressWarnings("unchecked")
    public String getAdditionalText(ConversationContext context, int number) {
        switch(number) {
        case 1:
            if (context.getSessionData(pref + CK.S_BREAK_NAMES) == null) {
                return ChatColor.GRAY + "(" + Lang.get("noneSet") + ")";
            } else {
                String text = "\n";
                LinkedList<String> names = (LinkedList<String>) context.getSessionData(pref + CK.S_BREAK_NAMES);
                LinkedList<Integer> amnts = (LinkedList<Integer>) context.getSessionData(pref + CK.S_BREAK_AMOUNTS);
                for (int i = 0; i < names.size(); i++) {
                    text += ChatColor.GRAY + "     - " + ChatColor.BLUE + ItemUtil.getPrettyItemName(names.get(i)) 
                            + ChatColor.GRAY + " x " + ChatColor.DARK_AQUA + amnts.get(i) + "\n";
                }
                return text;
            }
        case 2:
            if (context.getSessionData(pref + CK.S_DAMAGE_NAMES) == null) {
                return ChatColor.GRAY + "(" + Lang.get("noneSet") + ")";
            } else {
                String text = "\n";
                LinkedList<String> names = (LinkedList<String>) context.getSessionData(pref + CK.S_DAMAGE_NAMES);
                LinkedList<Integer> amnts = (LinkedList<Integer>) context.getSessionData(pref + CK.S_DAMAGE_AMOUNTS);
                for (int i = 0; i < names.size(); i++) {
                    text += ChatColor.GRAY + "     - " + ChatColor.BLUE + ItemUtil.getPrettyItemName(names.get(i)) 
                            + ChatColor.GRAY + " x " + ChatColor.DARK_AQUA + amnts.get(i) + "\n";
                }
                return text;
            }
        case 3:
            if (context.getSessionData(pref + CK.S_PLACE_NAMES) == null) {
                return ChatColor.GRAY + "(" + Lang.get("noneSet") + ")";
            } else {
                String text = "\n";
                LinkedList<String> names = (LinkedList<String>) context.getSessionData(pref + CK.S_PLACE_NAMES);
                LinkedList<Integer> amnts = (LinkedList<Integer>) context.getSessionData(pref + CK.S_PLACE_AMOUNTS);
                for (int i = 0; i < names.size(); i++) {
                    text += ChatColor.GRAY + "     - " + ChatColor.BLUE + ItemUtil.getPrettyItemName(names.get(i)) 
                            + ChatColor.GRAY + " x " + ChatColor.DARK_AQUA + amnts.get(i) + "\n";
                }
                return text;
            }
        case 4:
            if (context.getSessionData(pref + CK.S_USE_NAMES) == null) {
                return ChatColor.GRAY + "(" + Lang.get("noneSet") + ")";
            } else {
                String text = "\n";
                LinkedList<String> names = (LinkedList<String>) context.getSessionData(pref + CK.S_USE_NAMES);
                LinkedList<Integer> amnts = (LinkedList<Integer>) context.getSessionData(pref + CK.S_USE_AMOUNTS);
                for (int i = 0; i < names.size(); i++) {
                    text += ChatColor.GRAY + "     - " + ChatColor.BLUE + ItemUtil.getPrettyItemName(names.get(i)) 
                            + ChatColor.GRAY + " x " + ChatColor.DARK_AQUA + amnts.get(i) + "\n";
                }
                return text;
            }
        case 5:
            if (context.getSessionData(pref + CK.S_CUT_NAMES) == null) {
                return ChatColor.GRAY + " (" + Lang.get("noneSet") + ")";
            } else {
                String text = "\n";
                LinkedList<String> names = (LinkedList<String>) context.getSessionData(pref + CK.S_CUT_NAMES);
                LinkedList<Integer> amnts = (LinkedList<Integer>) context.getSessionData(pref + CK.S_CUT_AMOUNTS);
                for (int i = 0; i < names.size(); i++) {
                    text += ChatColor.GRAY + "     - " + ChatColor.BLUE + ItemUtil.getPrettyItemName(names.get(i)) 
                            + ChatColor.GRAY + " x " + ChatColor.DARK_AQUA + amnts.get(i) + "\n";
                }
                return text;
            }
        case 6:
            return "";
        default:
            return null;
        }
    }

    @Override
    public String getPromptText(ConversationContext context) {
        context.setSessionData(pref, Boolean.TRUE);
        
        QuestsEditorPostOpenNumericPromptEvent event = new QuestsEditorPostOpenNumericPromptEvent(context, this);
        context.getPlugin().getServer().getPluginManager().callEvent(event);

        String text = ChatColor.AQUA + "- " + getTitle(context) + " -\n";
        for (int i = 1; i <= size; i++) {
            text += getNumberColor(context, i) + "" + ChatColor.BOLD + i + ChatColor.RESET + " - " 
                    + getSelectionText(context, i) + " " + getAdditionalText(context, i) + "\n";
        }
        return text;
    }

    @Override
    protected Prompt acceptValidatedInput(ConversationContext context, Number input) {
        switch(input.intValue()) {
        case 1:
            return new BlocksBreakListPrompt(context);
        case 2:
            return new BlocksDamageListPrompt(context);
        case 3:
            return new BlocksPlaceListPrompt(context);
        case 4:
            return new BlocksUseListPrompt(context);
        case 5:
            return new BlocksShearListPrompt(context);
        case 6:
            try {
                return new StageMainPrompt(stageNum, context);
            } catch (Exception e) {
                context.getForWhom().sendRawMessage(ChatColor.RED + Lang.get("itemCreateCriticalError"));
                return Prompt.END_OF_CONVERSATION;
            }
        default:
            return new BlocksPrompt(stageNum, context);
        }
    }
    
    public class BlocksBreakListPrompt extends QuestsEditorNumericPrompt {

        public BlocksBreakListPrompt(ConversationContext context) {
            super(context);
        }

        private final int size = 5;
        
        public int getSize() {
            return size;
        }
        
        public String getTitle(ConversationContext context) {
            return Lang.get("stageEditorBreakBlocks");
        }

        public ChatColor getNumberColor(ConversationContext context, int number) {
            switch (number) {
                case 1: 
                case 2:
                case 3:
                    return ChatColor.BLUE;
                case 4:
                    return ChatColor.RED;
                case 5:
                    return ChatColor.GREEN;
                default:
                    return null;
            }
        }
        
        public String getSelectionText(ConversationContext context, int number) {
            switch(number) {
            case 1:
                return ChatColor.YELLOW + Lang.get("stageEditorSetBlockNames");
            case 2:
                return ChatColor.YELLOW + Lang.get("stageEditorSetBlockAmounts");
            case 3:
                return ChatColor.YELLOW + Lang.get("stageEditorSetBlockDurability");
            case 4:
                return ChatColor.RED + Lang.get("clear");
            case 5:
                return ChatColor.GREEN + Lang.get("done");
            default:
                return null;
            }
        }
        
        @SuppressWarnings("unchecked")
        public String getAdditionalText(ConversationContext context, int number) {
            switch(number) {
            case 1:
                if (context.getSessionData(pref + CK.S_BREAK_NAMES) != null) {
                    String text = "\n";
                    for (String s : (List<String>) context.getSessionData(pref + CK.S_BREAK_NAMES)) {
                        text += ChatColor.GRAY + "     - " + ChatColor.AQUA + ItemUtil.getPrettyItemName(s) + "\n";
                    }
                    return text;
                } else {
                    return "";
                }
            case 2:
                if (context.getSessionData(pref + CK.S_BREAK_AMOUNTS) != null) {
                    String text = "\n";
                    for (Integer i : (List<Integer>) context.getSessionData(pref + CK.S_BREAK_AMOUNTS)) {
                        text += ChatColor.GRAY + "     - " + ChatColor.AQUA + i + "\n";
                    }
                    return text;
                } else {
                    return "";
                }
            case 3:
                if (context.getSessionData(pref + CK.S_BREAK_DURABILITY) != null) {
                    String text = "\n";
                    for (Short s : (List<Short>) context.getSessionData(pref + CK.S_BREAK_DURABILITY)) {
                        text += ChatColor.GRAY + "     - " + ChatColor.AQUA + s + "\n";
                    }
                    return text;
                } else {
                    return "";
                }
            case 4:
            case 5:
                return "";
            default:
                return null;
            }
        }
        
        @Override
        public String getPromptText(ConversationContext context) {
            QuestsEditorPostOpenNumericPromptEvent event = new QuestsEditorPostOpenNumericPromptEvent(context, this);
            context.getPlugin().getServer().getPluginManager().callEvent(event);

            String text = ChatColor.GOLD + "- " + getTitle(context) + " -\n";
            for (int i = 1; i <= size; i++) {
                text += getNumberColor(context, i) + "" + ChatColor.BOLD + i + ChatColor.RESET + " - " 
                        + getSelectionText(context, i) + " " + getAdditionalText(context, i) + "\n";
            }
            return text;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        protected Prompt acceptValidatedInput(ConversationContext context, Number input) {
            switch(input.intValue()) {
            case 1:
                return new BlockBreakNamesPrompt(context);
            case 2:
                return new BlockBreakAmountsPrompt(context);
            case 3:
                return new BlockBreakDurabilityPrompt(context);
            case 4:
                context.getForWhom().sendRawMessage(ChatColor.YELLOW + Lang.get("stageEditorObjectiveCleared"));
                context.setSessionData(pref + CK.S_BREAK_NAMES, null);
                context.setSessionData(pref + CK.S_BREAK_AMOUNTS, null);
                context.setSessionData(pref + CK.S_BREAK_DURABILITY, null);
                return new BlocksBreakListPrompt(context);
            case 5:
                int one;
                int two;
                if (context.getSessionData(pref + CK.S_BREAK_NAMES) != null) {
                    one = ((List<Integer>) context.getSessionData(pref + CK.S_BREAK_NAMES)).size();
                } else {
                    one = 0;
                }
                if (context.getSessionData(pref + CK.S_BREAK_AMOUNTS) != null) {
                    two = ((List<Integer>) context.getSessionData(pref + CK.S_BREAK_AMOUNTS)).size();
                } else {
                    two = 0;
                }
                if (one == two) {                    
                    int missing;
                    LinkedList<Short> elements;
                    if (context.getSessionData(pref + CK.S_BREAK_DURABILITY) != null) {
                        missing = one - ((List<Short>) context.getSessionData(pref + CK.S_BREAK_DURABILITY)).size();
                        elements = (LinkedList<Short>) context.getSessionData(pref + CK.S_BREAK_DURABILITY);
                    } else {
                        missing = one;
                        elements = new LinkedList<Short>();
                    }
                    for (int i = 0; i < missing; i++) {
                        elements.add((short) 0);
                    }
                    context.setSessionData(pref + CK.S_BREAK_DURABILITY, elements);
                    return new BlocksPrompt(stageNum, context);
                } else {
                    context.getForWhom().sendRawMessage(ChatColor.RED + Lang.get("listsNotSameSize"));
                    return new BlocksBreakListPrompt(context);
                }
            default:
                return new BlocksPrompt(stageNum, context);
            }
        }
    }

    public class BlockBreakNamesPrompt extends QuestsEditorStringPrompt {

        public BlockBreakNamesPrompt(ConversationContext context) {
            super(context);
        }
        
        @Override
        public String getTitle(ConversationContext context) {
            return null;
        }

        @Override
        public String getQueryText(ConversationContext context) {
            return Lang.get("stageEditorEnterBlockNames");
        }

        @Override
        public String getPromptText(ConversationContext context) {
            QuestsEditorPostOpenStringPromptEvent event = new QuestsEditorPostOpenStringPromptEvent(context, this);
            context.getPlugin().getServer().getPluginManager().callEvent(event);
            
            return ChatColor.YELLOW + getQueryText(context);
        }

        @Override
        public Prompt acceptInput(ConversationContext context, String input) {
            if (input.equalsIgnoreCase(Lang.get("cmdCancel")) == false) {
                String[] args = input.split(" ");
                LinkedList<String> names = new LinkedList<String>();
                for (String s : args) {
                    try {
                        Material m = Material.matchMaterial(s);
                        if (m != null) {
                            if (m.isBlock()) {
                                names.add(s);
                            } else {
                                context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + ChatColor.RED + " " 
                                        + Lang.get("stageEditorNotSolid"));
                                return new BlockBreakNamesPrompt(context);
                            }
                        } else {
                            context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + ChatColor.RED + " " 
                                    + Lang.get("stageEditorInvalidBlockName"));
                            return new BlockBreakNamesPrompt(context);
                        }
                    } catch (NumberFormatException e) {
                        context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + " " + ChatColor.RED 
                                + Lang.get("stageEditorNotListofNumbers"));
                        return new BlockBreakNamesPrompt(context);
                    }
                }
                context.setSessionData(pref + CK.S_BREAK_NAMES, names);
            }
            return new BlocksBreakListPrompt(context);
        }
    }

    public class BlockBreakAmountsPrompt extends QuestsEditorStringPrompt {

        public BlockBreakAmountsPrompt(ConversationContext context) {
            super(context);
        }

        @Override
        public String getTitle(ConversationContext context) {
            return null;
        }

        @Override
        public String getQueryText(ConversationContext context) {
            return Lang.get("stageEditorEnterBlockAmounts");
        }

        @Override
        public String getPromptText(ConversationContext context) {
            QuestsEditorPostOpenStringPromptEvent event = new QuestsEditorPostOpenStringPromptEvent(context, this);
            context.getPlugin().getServer().getPluginManager().callEvent(event);
            
            return ChatColor.YELLOW + getQueryText(context);
        }

        @Override
        public Prompt acceptInput(ConversationContext context, String input) {
            if (input.equalsIgnoreCase(Lang.get("cmdCancel")) == false) {
                String[] args = input.split(" ");
                LinkedList<Integer> amounts = new LinkedList<Integer>();
                for (String s : args) {
                    try {
                        if (Integer.parseInt(s) > 0) {
                            amounts.add(Integer.parseInt(s));
                        } else {
                            context.getForWhom().sendRawMessage(ChatColor.RED 
                                    + Lang.get("invalidMinimum").replace("<number>", "1"));
                            return new BlockBreakAmountsPrompt(context);
                        }
                    } catch (NumberFormatException e) {
                        context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + " " + ChatColor.RED 
                                + Lang.get("stageEditorNotListofNumbers"));
                        return new BlockBreakAmountsPrompt(context);
                    }
                }
                context.setSessionData(pref + CK.S_BREAK_AMOUNTS, amounts);
            }
            return new BlocksBreakListPrompt(context);
        }
    }

    public class BlockBreakDurabilityPrompt extends QuestsEditorStringPrompt {

        public BlockBreakDurabilityPrompt(ConversationContext context) {
            super(context);
        }

        @Override
        public String getTitle(ConversationContext context) {
            return null;
        }

        @Override
        public String getQueryText(ConversationContext context) {
            return Lang.get("stageEditorEnterBlockDurability");
        }

        @Override
        public String getPromptText(ConversationContext context) {
            QuestsEditorPostOpenStringPromptEvent event = new QuestsEditorPostOpenStringPromptEvent(context, this);
            context.getPlugin().getServer().getPluginManager().callEvent(event);
            
            return ChatColor.YELLOW + getQueryText(context);
        }

        @Override
        public Prompt acceptInput(ConversationContext context, String input) {
            if (input.equalsIgnoreCase(Lang.get("cmdCancel")) == false) {
                String[] args = input.split(" ");
                LinkedList<Short> durability = new LinkedList<Short>();
                for (String s : args) {
                    try {
                        if (Short.parseShort(s) >= 0) {
                            durability.add(Short.parseShort(s));
                        } else {
                            context.getForWhom().sendRawMessage(ChatColor.RED 
                                    + Lang.get("invalidMinimum").replace("<number>", "0"));
                            return new BlockBreakDurabilityPrompt(context);
                        }
                    } catch (NumberFormatException e) {
                        context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + " " + ChatColor.RED 
                                + Lang.get("stageEditorNotListofNumbers"));
                        return new BlockBreakDurabilityPrompt(context);
                    }
                }
                context.setSessionData(pref + CK.S_BREAK_DURABILITY, durability);
            }
            return new BlocksBreakListPrompt(context);
        }
    }

    public class BlocksDamageListPrompt extends QuestsEditorNumericPrompt {
        
        public BlocksDamageListPrompt(ConversationContext context) {
            super(context);
        }

        private final int size = 5;
        
        public int getSize() {
            return size;
        }
        
        public String getTitle(ConversationContext context) {
            return Lang.get("stageEditorDamageBlocks");
        }

        public ChatColor getNumberColor(ConversationContext context, int number) {
            switch (number) {
                case 1: 
                case 2:
                case 3:
                    return ChatColor.BLUE;
                case 4:
                    return ChatColor.RED;
                case 5:
                    return ChatColor.GREEN;
                default:
                    return null;
            }
        }
        
        public String getSelectionText(ConversationContext context, int number) {
            switch(number) {
            case 1:
                return ChatColor.YELLOW + Lang.get("stageEditorSetBlockNames");
            case 2:
                return ChatColor.YELLOW + Lang.get("stageEditorSetBlockAmounts");
            case 3:
                return ChatColor.YELLOW + Lang.get("stageEditorSetBlockDurability");
            case 4:
                return ChatColor.RED + Lang.get("clear");
            case 5:
                return ChatColor.GREEN + Lang.get("done");
            default:
                return null;
            }
        }
        
        @SuppressWarnings("unchecked")
        public String getAdditionalText(ConversationContext context, int number) {
            switch(number) {
            case 1:
                if (context.getSessionData(pref + CK.S_DAMAGE_NAMES) != null) {
                    String text = "\n";
                    for (String s : (List<String>) context.getSessionData(pref + CK.S_DAMAGE_NAMES)) {
                        text += ChatColor.GRAY + "     - " + ChatColor.AQUA + ItemUtil.getPrettyItemName(s) + "\n";
                    }
                    return text;
                } else {
                    return "";
                }
            case 2:
                if (context.getSessionData(pref + CK.S_DAMAGE_AMOUNTS) != null) {
                    String text = "\n";
                    for (Integer i : (List<Integer>) context.getSessionData(pref + CK.S_DAMAGE_AMOUNTS)) {
                        text += ChatColor.GRAY + "     - " + ChatColor.AQUA + i + "\n";
                    }
                    return text;
                } else {
                    return "";
                }
            case 3:
                if (context.getSessionData(pref + CK.S_DAMAGE_DURABILITY) != null) {
                    String text = "\n";
                    for (Short s : (List<Short>) context.getSessionData(pref + CK.S_DAMAGE_DURABILITY)) {
                        text += ChatColor.GRAY + "     - " + ChatColor.AQUA + s + "\n";
                    }
                    return text;
                } else {
                    return "";
                }
            case 4:
            case 5:
                return "";
            default:
                return null;
            }
        }
        
        @Override
        public String getPromptText(ConversationContext context) {
            QuestsEditorPostOpenNumericPromptEvent event = new QuestsEditorPostOpenNumericPromptEvent(context, this);
            context.getPlugin().getServer().getPluginManager().callEvent(event);

            String text = ChatColor.GOLD + "- " + getTitle(context) + " -\n";
            for (int i = 1; i <= size; i++) {
                text += getNumberColor(context, i) + "" + ChatColor.BOLD + i + ChatColor.RESET + " - " 
                        + getSelectionText(context, i) + " " + getAdditionalText(context, i) + "\n";
            }
            return text;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        protected Prompt acceptValidatedInput(ConversationContext context, Number input) {
            switch(input.intValue()) {
            case 1:
                return new BlockDamageNamesPrompt(context);
            case 2:
                return new BlockDamageAmountsPrompt(context);
            case 3:
                return new BlockDamageDurabilityPrompt(context);
            case 4:
                context.getForWhom().sendRawMessage(ChatColor.YELLOW + Lang.get("stageEditorObjectiveCleared"));
                context.setSessionData(pref + CK.S_DAMAGE_NAMES, null);
                context.setSessionData(pref + CK.S_DAMAGE_AMOUNTS, null);
                context.setSessionData(pref + CK.S_DAMAGE_DURABILITY, null);
                return new BlocksDamageListPrompt(context);
            case 5:
                int one;
                int two;
                if (context.getSessionData(pref + CK.S_DAMAGE_NAMES) != null) {
                    one = ((List<String>) context.getSessionData(pref + CK.S_DAMAGE_NAMES)).size();
                } else {
                    one = 0;
                }
                if (context.getSessionData(pref + CK.S_DAMAGE_AMOUNTS) != null) {
                    two = ((List<Integer>) context.getSessionData(pref + CK.S_DAMAGE_AMOUNTS)).size();
                } else {
                    two = 0;
                }
                if (one == two) {
                    int missing;
                    LinkedList<Short> elements;
                    if (context.getSessionData(pref + CK.S_DAMAGE_DURABILITY) != null) {
                        missing = one - ((List<Short>) context.getSessionData(pref + CK.S_DAMAGE_DURABILITY)).size();
                        elements = (LinkedList<Short>) context.getSessionData(pref + CK.S_DAMAGE_DURABILITY);
                    } else {
                        missing = one;
                        elements = new LinkedList<Short>();
                    }
                    for (int i = 0; i < missing; i++) {
                        elements.add((short) 0);
                    }
                    context.setSessionData(pref + CK.S_DAMAGE_DURABILITY, elements);
                    return new BlocksPrompt(stageNum, context);
                } else {
                    context.getForWhom().sendRawMessage(ChatColor.RED + Lang.get("listsNotSameSize"));
                    return new BlocksDamageListPrompt(context);
                }
            default:
                return new BlocksPrompt(stageNum, context);
            }
        }
    }

    public class BlockDamageNamesPrompt extends QuestsEditorStringPrompt {

        public BlockDamageNamesPrompt(ConversationContext context) {
            super(context);
        }

        @Override
        public String getTitle(ConversationContext context) {
            return null;
        }

        @Override
        public String getQueryText(ConversationContext context) {
            return Lang.get("stageEditorEnterBlockNames");
        }

        @Override
        public String getPromptText(ConversationContext context) {
            QuestsEditorPostOpenStringPromptEvent event = new QuestsEditorPostOpenStringPromptEvent(context, this);
            context.getPlugin().getServer().getPluginManager().callEvent(event);
            
            return ChatColor.YELLOW + getQueryText(context);
        }

        @Override
        public Prompt acceptInput(ConversationContext context, String input) {
            if (input.equalsIgnoreCase(Lang.get("cmdCancel")) == false) {
                String[] args = input.split(" ");
                LinkedList<String> names = new LinkedList<String>();
                for (String s : args) {
                    try {
                        Material m = Material.matchMaterial(s);
                        if (m != null) {
                            if (m.isBlock()) {
                                names.add(s);
                            } else {
                                context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + ChatColor.RED + " " 
                                        + Lang.get("stageEditorNotSolid"));
                                return new BlockDamageNamesPrompt(context);
                            }
                        } else {
                            context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + ChatColor.RED + " " 
                                    + Lang.get("stageEditorInvalidBlockName"));
                            return new BlockDamageNamesPrompt(context);
                        }
                    } catch (NumberFormatException e) {
                        context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + " " + ChatColor.RED 
                                + Lang.get("stageEditorNotListofNumbers"));
                        return new BlockDamageNamesPrompt(context);
                    }
                }
                context.setSessionData(pref + CK.S_DAMAGE_NAMES, names);
            }
            return new BlocksDamageListPrompt(context);
        }
    }

    public class BlockDamageAmountsPrompt extends QuestsEditorStringPrompt {

        public BlockDamageAmountsPrompt(ConversationContext context) {
            super(context);
        }

        @Override
        public String getTitle(ConversationContext context) {
            return null;
        }

        @Override
        public String getQueryText(ConversationContext context) {
            return Lang.get("stageEditorEnterBlockAmounts");
        }

        @Override
        public String getPromptText(ConversationContext context) {
            QuestsEditorPostOpenStringPromptEvent event = new QuestsEditorPostOpenStringPromptEvent(context, this);
            context.getPlugin().getServer().getPluginManager().callEvent(event);
            
            return ChatColor.YELLOW + getQueryText(context);
        }

        @Override
        public Prompt acceptInput(ConversationContext context, String input) {
            if (input.equalsIgnoreCase(Lang.get("cmdCancel")) == false) {
                String[] args = input.split(" ");
                LinkedList<Integer> amounts = new LinkedList<Integer>();
                for (String s : args) {
                    try {
                        if (Integer.parseInt(s) > 0) {
                            amounts.add(Integer.parseInt(s));
                        } else {
                            context.getForWhom().sendRawMessage(ChatColor.RED 
                                    + Lang.get("invalidMinimum").replace("<number>", "1"));
                            return new BlockDamageAmountsPrompt(context);
                        }
                    } catch (NumberFormatException e) {
                        context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + " " + ChatColor.RED 
                                + Lang.get("stageEditorNotListofNumbers"));
                        return new BlockDamageAmountsPrompt(context);
                    }
                }
                context.setSessionData(pref + CK.S_DAMAGE_AMOUNTS, amounts);
            }
            return new BlocksDamageListPrompt(context);
        }
    }

    public class BlockDamageDurabilityPrompt extends QuestsEditorStringPrompt {

        public BlockDamageDurabilityPrompt(ConversationContext context) {
            super(context);
        }

        @Override
        public String getTitle(ConversationContext context) {
            return null;
        }

        @Override
        public String getQueryText(ConversationContext context) {
            return Lang.get("stageEditorEnterBlockDurability");
        }

        @Override
        public String getPromptText(ConversationContext context) {
            QuestsEditorPostOpenStringPromptEvent event = new QuestsEditorPostOpenStringPromptEvent(context, this);
            context.getPlugin().getServer().getPluginManager().callEvent(event);
            
            return ChatColor.YELLOW + getQueryText(context);
        }

        @Override
        public Prompt acceptInput(ConversationContext context, String input) {
            if (input.equalsIgnoreCase(Lang.get("cmdCancel")) == false) {
                String[] args = input.split(" ");
                LinkedList<Short> durability = new LinkedList<Short>();
                for (String s : args) {
                    try {
                        if (Short.parseShort(s) >= 0) {
                            durability.add(Short.parseShort(s));
                        } else {
                            context.getForWhom().sendRawMessage(ChatColor.RED 
                                    + Lang.get("invalidMinimum").replace("<number>", "0"));
                            return new BlockDamageDurabilityPrompt(context);
                        }
                    } catch (NumberFormatException e) {
                        context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + " " + ChatColor.RED 
                                + Lang.get("stageEditorNotListofNumbers"));
                        return new BlockDamageDurabilityPrompt(context);
                    }
                }
                context.setSessionData(pref + CK.S_DAMAGE_DURABILITY, durability);
            }
            return new BlocksDamageListPrompt(context);
        }
    }

    public class BlocksPlaceListPrompt extends QuestsEditorNumericPrompt {

        public BlocksPlaceListPrompt(ConversationContext context) {
            super(context);
        }

        private final int size = 5;
        
        public int getSize() {
            return size;
        }
        
        public String getTitle(ConversationContext context) {
            return Lang.get("stageEditorPlaceBlocks");
        }

        public ChatColor getNumberColor(ConversationContext context, int number) {
            switch (number) {
                case 1: 
                case 2:
                case 3:
                    return ChatColor.BLUE;
                case 4:
                    return ChatColor.RED;
                case 5:
                    return ChatColor.GREEN;
                default:
                    return null;
            }
        }
        
        public String getSelectionText(ConversationContext context, int number) {
            switch(number) {
            case 1:
                return ChatColor.YELLOW + Lang.get("stageEditorSetBlockNames");
            case 2:
                return ChatColor.YELLOW + Lang.get("stageEditorSetBlockAmounts");
            case 3:
                return ChatColor.YELLOW + Lang.get("stageEditorSetBlockDurability");
            case 4:
                return ChatColor.RED + Lang.get("clear");
            case 5:
                return ChatColor.GREEN + Lang.get("done");
            default:
                return null;
            }
        }
        
        @SuppressWarnings("unchecked")
        public String getAdditionalText(ConversationContext context, int number) {
            switch(number) {
            case 1:
                if (context.getSessionData(pref + CK.S_PLACE_NAMES) != null) {
                    String text = "\n";
                    for (String s : (List<String>) context.getSessionData(pref + CK.S_PLACE_NAMES)) {
                        text += ChatColor.GRAY + "     - " + ChatColor.AQUA + ItemUtil.getPrettyItemName(s) + "\n";
                    }
                    return text;
                } else {
                    return "";
                }
            case 2:
                if (context.getSessionData(pref + CK.S_PLACE_AMOUNTS) != null) {
                    String text = "\n";
                    for (Integer i : (List<Integer>) context.getSessionData(pref + CK.S_PLACE_AMOUNTS)) {
                        text += ChatColor.GRAY + "     - " + ChatColor.AQUA + i + "\n";
                    }
                    return text;
                } else {
                    return "";
                }
            case 3:
                if (context.getSessionData(pref + CK.S_PLACE_DURABILITY) != null) {
                    String text = "\n";
                    for (Short s : (List<Short>) context.getSessionData(pref + CK.S_PLACE_DURABILITY)) {
                        text += ChatColor.GRAY + "     - " + ChatColor.AQUA + s + "\n";
                    }
                    return text;
                } else {
                    return "";
                }
            case 4:
            case 5:
                return "";
            default:
                return null;
            }
        }
        
        @Override
        public String getPromptText(ConversationContext context) {
            QuestsEditorPostOpenNumericPromptEvent event = new QuestsEditorPostOpenNumericPromptEvent(context, this);
            context.getPlugin().getServer().getPluginManager().callEvent(event);

            String text = ChatColor.GOLD + "- " + getTitle(context) + " -\n";
            for (int i = 1; i <= size; i++) {
                text += getNumberColor(context, i) + "" + ChatColor.BOLD + i + ChatColor.RESET + " - " 
                        + getSelectionText(context, i) + " " + getAdditionalText(context, i) + "\n";
            }
            return text;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        protected Prompt acceptValidatedInput(ConversationContext context, Number input) {
            switch(input.intValue()) {
            case 1:
                return new BlockPlaceNamesPrompt(context);
            case 2:
                return new BlockPlaceAmountsPrompt(context);
            case 3:
                return new BlockPlaceDurabilityPrompt(context);
            case 4:
                context.getForWhom().sendRawMessage(ChatColor.YELLOW + Lang.get("stageEditorObjectiveCleared"));
                context.setSessionData(pref + CK.S_PLACE_NAMES, null);
                context.setSessionData(pref + CK.S_PLACE_AMOUNTS, null);
                context.setSessionData(pref + CK.S_PLACE_DURABILITY, null);
                return new BlocksPlaceListPrompt(context);
            case 5:
                int one;
                int two;
                if (context.getSessionData(pref + CK.S_PLACE_NAMES) != null) {
                    one = ((List<String>) context.getSessionData(pref + CK.S_PLACE_NAMES)).size();
                } else {
                    one = 0;
                }
                if (context.getSessionData(pref + CK.S_PLACE_AMOUNTS) != null) {
                    two = ((List<Integer>) context.getSessionData(pref + CK.S_PLACE_AMOUNTS)).size();
                } else {
                    two = 0;
                }
                if (one == two) {
                    int missing;
                    LinkedList<Short> elements;
                    if (context.getSessionData(pref + CK.S_PLACE_DURABILITY) != null) {
                        missing = one - ((List<Short>) context.getSessionData(pref + CK.S_PLACE_DURABILITY)).size();
                        elements = (LinkedList<Short>) context.getSessionData(pref + CK.S_PLACE_DURABILITY);
                    } else {
                        missing = one;
                        elements = new LinkedList<Short>();
                    }
                    for (int i = 0; i < missing; i++) {
                        elements.add((short) 0);
                    }
                    context.setSessionData(pref + CK.S_PLACE_DURABILITY, elements);
                    return new BlocksPrompt(stageNum, context);
                } else {
                    context.getForWhom().sendRawMessage(ChatColor.RED + Lang.get("listsNotSameSize"));
                    return new BlocksPlaceListPrompt(context);
                }
            default:
                return new BlocksPrompt(stageNum, context);
            }
        }
    }

    public class BlockPlaceNamesPrompt extends QuestsEditorStringPrompt {

        public BlockPlaceNamesPrompt(ConversationContext context) {
            super(context);
        }

        @Override
        public String getTitle(ConversationContext context) {
            return null;
        }

        @Override
        public String getQueryText(ConversationContext context) {
            return Lang.get("stageEditorEnterBlockNames");
        }

        @Override
        public String getPromptText(ConversationContext context) {
            QuestsEditorPostOpenStringPromptEvent event = new QuestsEditorPostOpenStringPromptEvent(context, this);
            context.getPlugin().getServer().getPluginManager().callEvent(event);
            
            return ChatColor.YELLOW + getQueryText(context);
        }

        @Override
        public Prompt acceptInput(ConversationContext context, String input) {
            if (input.equalsIgnoreCase(Lang.get("cmdCancel")) == false) {
                String[] args = input.split(" ");
                LinkedList<String> names = new LinkedList<String>();
                for (String s : args) {
                    try {
                        Material m = Material.matchMaterial(s);
                        if (m != null) {
                            if (m.isBlock()) {
                                names.add(s);
                            } else {
                                context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + ChatColor.RED + " " 
                                        + Lang.get("stageEditorNotSolid"));
                                return new BlockPlaceNamesPrompt(context);
                            }
                        } else {
                            context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + ChatColor.RED 
                                    + Lang.get("stageEditorInvalidBlockName"));
                            return new BlockPlaceNamesPrompt(context);
                        }
                    } catch (NumberFormatException e) {
                        context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + " " + ChatColor.RED 
                                + Lang.get("stageEditorNotListofNumbers"));
                        return new BlockPlaceNamesPrompt(context);
                    }
                }
                context.setSessionData(pref + CK.S_PLACE_NAMES, names);
            }
            return new BlocksPlaceListPrompt(context);
        }
    }

    public class BlockPlaceAmountsPrompt extends QuestsEditorStringPrompt {

        public BlockPlaceAmountsPrompt(ConversationContext context) {
            super(context);
        }

        @Override
        public String getTitle(ConversationContext context) {
            return null;
        }

        @Override
        public String getQueryText(ConversationContext context) {
            return Lang.get("stageEditorEnterBlockAmounts");
        }

        @Override
        public String getPromptText(ConversationContext context) {
            QuestsEditorPostOpenStringPromptEvent event = new QuestsEditorPostOpenStringPromptEvent(context, this);
            context.getPlugin().getServer().getPluginManager().callEvent(event);
            
            return ChatColor.YELLOW + getQueryText(context);
        }

        @Override
        public Prompt acceptInput(ConversationContext context, String input) {
            if (input.equalsIgnoreCase(Lang.get("cmdCancel")) == false) {
                String[] args = input.split(" ");
                LinkedList<Integer> amounts = new LinkedList<Integer>();
                for (String s : args) {
                    try {
                        if (Integer.parseInt(s) > 0) {
                            amounts.add(Integer.parseInt(s));
                        } else {
                            context.getForWhom().sendRawMessage(ChatColor.RED 
                                    + Lang.get("invalidMinimum").replace("<number>", "1"));
                            return new BlockPlaceAmountsPrompt(context);
                        }
                    } catch (NumberFormatException e) {
                        context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + " " + ChatColor.RED 
                                + Lang.get("stageEditorNotListofNumbers"));
                        return new BlockPlaceAmountsPrompt(context);
                    }
                }
                context.setSessionData(pref + CK.S_PLACE_AMOUNTS, amounts);
            }
            return new BlocksPlaceListPrompt(context);
        }
    }

    public class BlockPlaceDurabilityPrompt extends QuestsEditorStringPrompt {

        public BlockPlaceDurabilityPrompt(ConversationContext context) {
            super(context);
        }

        @Override
        public String getTitle(ConversationContext context) {
            return null;
        }

        @Override
        public String getQueryText(ConversationContext context) {
            return Lang.get("stageEditorEnterBlockDurability");
        }

        @Override
        public String getPromptText(ConversationContext context) {
            QuestsEditorPostOpenStringPromptEvent event = new QuestsEditorPostOpenStringPromptEvent(context, this);
            context.getPlugin().getServer().getPluginManager().callEvent(event);
            
            return ChatColor.YELLOW + getQueryText(context);
        }

        @Override
        public Prompt acceptInput(ConversationContext context, String input) {
            if (input.equalsIgnoreCase(Lang.get("cmdCancel")) == false) {
                String[] args = input.split(" ");
                LinkedList<Short> durability = new LinkedList<Short>();
                for (String s : args) {
                    try {
                        if (Short.parseShort(s) >= 0) {
                            durability.add(Short.parseShort(s));
                        } else {
                            context.getForWhom().sendRawMessage(ChatColor.RED 
                                    + Lang.get("invalidMinimum").replace("<number>", "0"));
                            return new BlockPlaceDurabilityPrompt(context);
                        }
                    } catch (NumberFormatException e) {
                        context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + " " + ChatColor.RED 
                                + Lang.get("stageEditorNotListofNumbers"));
                        return new BlockPlaceDurabilityPrompt(context);
                    }
                }
                context.setSessionData(pref + CK.S_PLACE_DURABILITY, durability);
            }
            return new BlocksPlaceListPrompt(context);
        }
    }

    public class BlocksUseListPrompt extends QuestsEditorNumericPrompt {

        public BlocksUseListPrompt(ConversationContext context) {
            super(context);
        }

        private final int size = 5;
        
        public int getSize() {
            return size;
        }
        
        public String getTitle(ConversationContext context) {
            return Lang.get("stageEditorUseBlocks");
        }

        public ChatColor getNumberColor(ConversationContext context, int number) {
            switch (number) {
                case 1: 
                case 2:
                case 3:
                    return ChatColor.BLUE;
                case 4:
                    return ChatColor.RED;
                case 5:
                    return ChatColor.GREEN;
                default:
                    return null;
            }
        }
        
        public String getSelectionText(ConversationContext context, int number) {
            switch(number) {
            case 1:
                return ChatColor.YELLOW + Lang.get("stageEditorSetBlockNames");
            case 2:
                return ChatColor.YELLOW + Lang.get("stageEditorSetBlockAmounts");
            case 3:
                return ChatColor.YELLOW + Lang.get("stageEditorSetBlockDurability");
            case 4:
                return ChatColor.RED + Lang.get("clear");
            case 5:
                return ChatColor.GREEN + Lang.get("done");
            default:
                return null;
            }
        }
        
        @SuppressWarnings("unchecked")
        public String getAdditionalText(ConversationContext context, int number) {
            switch(number) {
            case 1:
                if (context.getSessionData(pref + CK.S_USE_NAMES) != null) {
                    String text = "\n";
                    for (String s : (List<String>) context.getSessionData(pref + CK.S_USE_NAMES)) {
                        text += ChatColor.GRAY + "     - " + ChatColor.AQUA + ItemUtil.getPrettyItemName(s) + "\n";
                    }
                    return text;
                } else {
                    return "";
                }
            case 2:
                if (context.getSessionData(pref + CK.S_USE_AMOUNTS) != null) {
                    String text = "\n";
                    for (Integer i : (List<Integer>) context.getSessionData(pref + CK.S_USE_AMOUNTS)) {
                        text += ChatColor.GRAY + "     - " + ChatColor.AQUA + i + "\n";
                    }
                    return text;
                } else {
                    return "";
                }
            case 3:
                if (context.getSessionData(pref + CK.S_USE_DURABILITY) != null) {
                    String text = "\n";
                    for (Short s : (List<Short>) context.getSessionData(pref + CK.S_USE_DURABILITY)) {
                        text += ChatColor.GRAY + "     - " + ChatColor.AQUA + s + "\n";
                    }
                    return text;
                } else {
                    return "";
                }
            case 4:
            case 5:
                return "";
            default:
                return null;
            }
        }
        
        @Override
        public String getPromptText(ConversationContext context) {
            QuestsEditorPostOpenNumericPromptEvent event = new QuestsEditorPostOpenNumericPromptEvent(context, this);
            context.getPlugin().getServer().getPluginManager().callEvent(event);

            String text = ChatColor.GOLD + "- " + getTitle(context) + " -\n";
            for (int i = 1; i <= size; i++) {
                text += getNumberColor(context, i) + "" + ChatColor.BOLD + i + ChatColor.RESET + " - " 
                        + getSelectionText(context, i) + " " + getAdditionalText(context, i) + "\n";
            }
            return text;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        protected Prompt acceptValidatedInput(ConversationContext context, Number input) {
            switch(input.intValue()) {
            case 1:
                return new BlockUseNamesPrompt(context);
            case 2:
                return new BlockUseAmountsPrompt(context);
            case 3:
                return new BlockUseDurabilityPrompt(context);
            case 4:
                context.getForWhom().sendRawMessage(ChatColor.YELLOW + Lang.get("stageEditorObjectiveCleared"));
                context.setSessionData(pref + CK.S_USE_NAMES, null);
                context.setSessionData(pref + CK.S_USE_AMOUNTS, null);
                context.setSessionData(pref + CK.S_USE_DURABILITY, null);
                return new BlocksUseListPrompt(context);
            case 5:
                int one;
                int two;
                if (context.getSessionData(pref + CK.S_USE_NAMES) != null) {
                    one = ((List<String>) context.getSessionData(pref + CK.S_USE_NAMES)).size();
                } else {
                    one = 0;
                }
                if (context.getSessionData(pref + CK.S_USE_AMOUNTS) != null) {
                    two = ((List<Integer>) context.getSessionData(pref + CK.S_USE_AMOUNTS)).size();
                } else {
                    two = 0;
                }
                if (one == two) {
                    int missing;
                    LinkedList<Short> elements;
                    if (context.getSessionData(pref + CK.S_USE_DURABILITY) != null) {
                        missing = one - ((List<Short>) context.getSessionData(pref + CK.S_USE_DURABILITY)).size();
                        elements = (LinkedList<Short>) context.getSessionData(pref + CK.S_USE_DURABILITY);
                    } else {
                        missing = one;
                        elements = new LinkedList<Short>();
                    }
                    for (int i = 0; i < missing; i++) {
                        elements.add((short) 0);
                    }
                    context.setSessionData(pref + CK.S_USE_DURABILITY, elements);
                    return new BlocksPrompt(stageNum, context);
                } else {
                    context.getForWhom().sendRawMessage(ChatColor.RED + Lang.get("listsNotSameSize"));
                    return new BlocksUseListPrompt(context);
                }
            default:
                return new BlocksPrompt(stageNum, context);
            }
        }
    }

    public class BlockUseNamesPrompt extends QuestsEditorStringPrompt {

        public BlockUseNamesPrompt(ConversationContext context) {
            super(context);
        }

        @Override
        public String getTitle(ConversationContext context) {
            return null;
        }

        @Override
        public String getQueryText(ConversationContext context) {
            return Lang.get("stageEditorEnterBlockNames");
        }

        @Override
        public String getPromptText(ConversationContext context) {
            QuestsEditorPostOpenStringPromptEvent event = new QuestsEditorPostOpenStringPromptEvent(context, this);
            context.getPlugin().getServer().getPluginManager().callEvent(event);
            
            return ChatColor.YELLOW + getQueryText(context);
        }

        @Override
        public Prompt acceptInput(ConversationContext context, String input) {
            if (input.equalsIgnoreCase(Lang.get("cmdCancel")) == false) {
                String[] args = input.split(" ");
                LinkedList<String> names = new LinkedList<String>();
                for (String s : args) {
                    try {
                        Material m = Material.matchMaterial(s);
                        if (m != null) {
                            if (m.isBlock()) {
                                names.add(s);
                            } else {
                                context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + ChatColor.RED + " " 
                                        + Lang.get("stageEditorNotSolid"));
                                return new BlockUseNamesPrompt(context);
                            }
                        } else {
                            context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + ChatColor.RED + " " 
                                    + Lang.get("stageEditorInvalidBlockName"));
                            return new BlockUseNamesPrompt(context);
                        }
                    } catch (NumberFormatException e) {
                        context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + " " + ChatColor.RED 
                                + Lang.get("stageEditorNotListofNumbers"));
                        return new BlockUseNamesPrompt(context);
                    }
                }
                context.setSessionData(pref + CK.S_USE_NAMES, names);
            }
            return new BlocksUseListPrompt(context);
        }
    }

    public class BlockUseAmountsPrompt extends QuestsEditorStringPrompt {

        public BlockUseAmountsPrompt(ConversationContext context) {
            super(context);
        }

        @Override
        public String getTitle(ConversationContext context) {
            return null;
        }

        @Override
        public String getQueryText(ConversationContext context) {
            return Lang.get("stageEditorEnterBlockAmounts");
        }

        @Override
        public String getPromptText(ConversationContext context) {
            QuestsEditorPostOpenStringPromptEvent event = new QuestsEditorPostOpenStringPromptEvent(context, this);
            context.getPlugin().getServer().getPluginManager().callEvent(event);
            
            return ChatColor.YELLOW + getQueryText(context);
        }

        @Override
        public Prompt acceptInput(ConversationContext context, String input) {
            if (input.equalsIgnoreCase(Lang.get("cmdCancel")) == false) {
                String[] args = input.split(" ");
                LinkedList<Integer> amounts = new LinkedList<Integer>();
                for (String s : args) {
                    try {
                        if (Integer.parseInt(s) > 0) {
                            amounts.add(Integer.parseInt(s));
                        } else {
                            context.getForWhom().sendRawMessage(ChatColor.RED 
                                    + Lang.get("invalidMinimum").replace("<number>", "1"));
                            return new BlockUseAmountsPrompt(context);
                        }
                    } catch (NumberFormatException e) {
                        context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + " " + ChatColor.RED 
                                + Lang.get("stageEditorNotListofNumbers"));
                        return new BlockUseAmountsPrompt(context);
                    }
                }
                context.setSessionData(pref + CK.S_USE_AMOUNTS, amounts);
            }
            return new BlocksUseListPrompt(context);
        }
    }

    public class BlockUseDurabilityPrompt extends QuestsEditorStringPrompt {

        public BlockUseDurabilityPrompt(ConversationContext context) {
            super(context);
        }

        @Override
        public String getTitle(ConversationContext context) {
            return null;
        }

        @Override
        public String getQueryText(ConversationContext context) {
            return Lang.get("stageEditorEnterBlockDurability");
        }

        @Override
        public String getPromptText(ConversationContext context) {
            QuestsEditorPostOpenStringPromptEvent event = new QuestsEditorPostOpenStringPromptEvent(context, this);
            context.getPlugin().getServer().getPluginManager().callEvent(event);
            
            return ChatColor.YELLOW + getQueryText(context);
        }

        @Override
        public Prompt acceptInput(ConversationContext context, String input) {
            if (input.equalsIgnoreCase(Lang.get("cmdCancel")) == false) {
                String[] args = input.split(" ");
                LinkedList<Short> durability = new LinkedList<Short>();
                for (String s : args) {
                    try {
                        if (Short.parseShort(s) >= 0) {
                            durability.add(Short.parseShort(s));
                        } else {
                            context.getForWhom().sendRawMessage(ChatColor.RED 
                                    + Lang.get("invalidMinimum").replace("<number>", "0"));
                            return new BlockUseDurabilityPrompt(context);
                        }
                    } catch (NumberFormatException e) {
                        context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + " " + ChatColor.RED 
                                + Lang.get("stageEditorNotListofNumbers"));
                        return new BlockUseDurabilityPrompt(context);
                    }
                }
                context.setSessionData(pref + CK.S_USE_DURABILITY, durability);
            }
            return new BlocksUseListPrompt(context);
        }
    }

    public class BlocksShearListPrompt extends QuestsEditorNumericPrompt {

        public BlocksShearListPrompt(ConversationContext context) {
            super(context);
        }

        private final int size = 5;
        
        public int getSize() {
            return size;
        }
        
        public String getTitle(ConversationContext context) {
            return Lang.get("stageEditorCutBlocks");
        }

        public ChatColor getNumberColor(ConversationContext context, int number) {
            switch (number) {
                case 1: 
                case 2:
                case 3:
                    return ChatColor.BLUE;
                case 4:
                    return ChatColor.RED;
                case 5:
                    return ChatColor.GREEN;
                default:
                    return null;
            }
        }
        
        public String getSelectionText(ConversationContext context, int number) {
            switch(number) {
            case 1:
                return ChatColor.YELLOW + Lang.get("stageEditorSetBlockNames");
            case 2:
                return ChatColor.YELLOW + Lang.get("stageEditorSetBlockAmounts");
            case 3:
                return ChatColor.YELLOW + Lang.get("stageEditorSetBlockDurability");
            case 4:
                return ChatColor.RED + Lang.get("clear");
            case 5:
                return ChatColor.GREEN + Lang.get("done");
            default:
                return null;
            }
        }
        
        @SuppressWarnings("unchecked")
        public String getAdditionalText(ConversationContext context, int number) {
            switch(number) {
            case 1:
                if (context.getSessionData(pref + CK.S_CUT_NAMES) != null) {
                    String text = "\n";
                    for (String s : (List<String>) context.getSessionData(pref + CK.S_CUT_NAMES)) {
                        text += ChatColor.GRAY + "     - " + ChatColor.AQUA + ItemUtil.getPrettyItemName(s) + "\n";
                    }
                    return text;
                } else {
                    return "";
                }
            case 2:
                if (context.getSessionData(pref + CK.S_CUT_AMOUNTS) != null) {
                    String text = "\n";
                    for (Integer i : (List<Integer>) context.getSessionData(pref + CK.S_CUT_AMOUNTS)) {
                        text += ChatColor.GRAY + "     - " + ChatColor.AQUA + i + "\n";
                    }
                    return text;
                } else {
                    return "";
                }
            case 3:
                if (context.getSessionData(pref + CK.S_CUT_DURABILITY) != null) {
                    String text = "\n";
                    for (Short s : (List<Short>) context.getSessionData(pref + CK.S_CUT_DURABILITY)) {
                        text += ChatColor.GRAY + "     - " + ChatColor.AQUA + s + "\n";
                    }
                    return text;
                } else {
                    return "";
                }
            case 4:
            case 5:
                return "";
            default:
                return null;
            }
        }
        
        @Override
        public String getPromptText(ConversationContext context) {
            QuestsEditorPostOpenNumericPromptEvent event = new QuestsEditorPostOpenNumericPromptEvent(context, this);
            context.getPlugin().getServer().getPluginManager().callEvent(event);

            String text = ChatColor.GOLD + "- " + getTitle(context) + " -\n";
            for (int i = 1; i <= size; i++) {
                text += getNumberColor(context, i) + "" + ChatColor.BOLD + i + ChatColor.RESET + " - " 
                        + getSelectionText(context, i) + " " + getAdditionalText(context, i) + "\n";
            }
            return text;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        protected Prompt acceptValidatedInput(ConversationContext context, Number input) {
            switch(input.intValue()) {
            case 1:
                return new BlockShearNamesPrompt(context);
            case 2:
                return new BlockShearAmountsPrompt(context);
            case 3:
                return new BlockShearDurabilityPrompt(context);
            case 4:
                context.getForWhom().sendRawMessage(ChatColor.YELLOW + Lang.get("stageEditorObjectiveCleared"));
                context.setSessionData(pref + CK.S_CUT_NAMES, null);
                context.setSessionData(pref + CK.S_CUT_AMOUNTS, null);
                context.setSessionData(pref + CK.S_CUT_DURABILITY, null);
                return new BlocksShearListPrompt(context);
            case 5:
                int one;
                int two;
                if (context.getSessionData(pref + CK.S_CUT_NAMES) != null) {
                    one = ((List<Integer>) context.getSessionData(pref + CK.S_CUT_NAMES)).size();
                } else {
                    one = 0;
                }
                if (context.getSessionData(pref + CK.S_CUT_AMOUNTS) != null) {
                    two = ((List<Integer>) context.getSessionData(pref + CK.S_CUT_AMOUNTS)).size();
                } else {
                    two = 0;
                }
                if (one == two) {
                    int missing;
                    LinkedList<Short> elements;
                    if (context.getSessionData(pref + CK.S_CUT_DURABILITY) != null) {
                        missing = one - ((List<Short>) context.getSessionData(pref + CK.S_CUT_DURABILITY)).size();
                        elements = (LinkedList<Short>) context.getSessionData(pref + CK.S_CUT_DURABILITY);
                    } else {
                        missing = one;
                        elements = new LinkedList<Short>();
                    }
                    for (int i = 0; i < missing; i++) {
                        elements.add((short) 0);
                    }
                    context.setSessionData(pref + CK.S_CUT_DURABILITY, elements);
                    return new BlocksPrompt(stageNum, context);
                } else {
                    context.getForWhom().sendRawMessage(ChatColor.RED + Lang.get("listsNotSameSize"));
                    return new BlocksShearListPrompt(context);
                }
            default:
                return new BlocksPrompt(stageNum, context);
            }
        }
    }

    public class BlockShearNamesPrompt extends QuestsEditorStringPrompt {
        
        public BlockShearNamesPrompt(ConversationContext context) {
            super(context);
        }

        @Override
        public String getTitle(ConversationContext context) {
            return null;
        }

        @Override
        public String getQueryText(ConversationContext context) {
            return Lang.get("stageEditorEnterBlockNames");
        }

        @Override
        public String getPromptText(ConversationContext context) {
            QuestsEditorPostOpenStringPromptEvent event = new QuestsEditorPostOpenStringPromptEvent(context, this);
            context.getPlugin().getServer().getPluginManager().callEvent(event);
            
            return ChatColor.YELLOW + getQueryText(context);
        }

        @Override
        public Prompt acceptInput(ConversationContext context, String input) {
            if (input.equalsIgnoreCase(Lang.get("cmdCancel")) == false) {
                String[] args = input.split(" ");
                LinkedList<String> names = new LinkedList<String>();
                for (String s : args) {
                    try {
                        Material m = Material.matchMaterial(s);
                        if (m != null) {
                            if (m.isBlock()) {
                                names.add(s);
                            } else {
                                context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + ChatColor.RED + " "
                                        + Lang.get("stageEditorNotSolid"));
                                return new BlockShearNamesPrompt(context);
                            }
                        } else {
                            context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + ChatColor.RED + " "
                                    + Lang.get("stageEditorInvalidBlockName"));
                            return new BlockShearNamesPrompt(context);
                        }
                    } catch (NumberFormatException e) {
                        context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + " " + ChatColor.RED
                                + Lang.get("stageEditorNotListofNumbers"));
                        return new BlockShearNamesPrompt(context);
                    }
                }
                context.setSessionData(pref + CK.S_CUT_NAMES, names);
            }
            return new BlocksShearListPrompt(context);
        }
    }

    public class BlockShearAmountsPrompt extends QuestsEditorStringPrompt {

        public BlockShearAmountsPrompt(ConversationContext context) {
            super(context);
        }
        
        @Override
        public String getTitle(ConversationContext context) {
            return null;
        }

        @Override
        public String getQueryText(ConversationContext context) {
            return Lang.get("stageEditorEnterBlockAmounts");
        }

        @Override
        public String getPromptText(ConversationContext context) {
            QuestsEditorPostOpenStringPromptEvent event = new QuestsEditorPostOpenStringPromptEvent(context, this);
            context.getPlugin().getServer().getPluginManager().callEvent(event);
            
            return ChatColor.YELLOW + getQueryText(context);
        }

        @Override
        public Prompt acceptInput(ConversationContext context, String input) {
            if (input.equalsIgnoreCase(Lang.get("cmdCancel")) == false) {
                String[] args = input.split(" ");
                LinkedList<Integer> amounts = new LinkedList<Integer>();
                for (String s : args) {
                    try {
                        if (Integer.parseInt(s) > 0) {
                            amounts.add(Integer.parseInt(s));
                        } else {
                            context.getForWhom().sendRawMessage(ChatColor.RED 
                                    + Lang.get("invalidMinimum").replace("<number>", "1"));
                            return new BlockShearAmountsPrompt(context);
                        }
                    } catch (NumberFormatException e) {
                        context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + " " + ChatColor.RED 
                                + Lang.get("stageEditorNotListofNumbers"));
                        return new BlockShearAmountsPrompt(context);
                    }
                }
                context.setSessionData(pref + CK.S_CUT_AMOUNTS, amounts);
            }
            return new BlocksShearListPrompt(context);
        }
    }

    public class BlockShearDurabilityPrompt extends QuestsEditorStringPrompt {

        public BlockShearDurabilityPrompt(ConversationContext context) {
            super(context);
        }
        
        @Override
        public String getTitle(ConversationContext context) {
            return null;
        }

        @Override
        public String getQueryText(ConversationContext context) {
            return Lang.get("stageEditorEnterBlockDurability");
        }

        @Override
        public String getPromptText(ConversationContext context) {
            QuestsEditorPostOpenStringPromptEvent event = new QuestsEditorPostOpenStringPromptEvent(context, this);
            context.getPlugin().getServer().getPluginManager().callEvent(event);
            
            return ChatColor.YELLOW + getQueryText(context);
        }

        @Override
        public Prompt acceptInput(ConversationContext context, String input) {
            if (input.equalsIgnoreCase(Lang.get("cmdCancel")) == false) {
                String[] args = input.split(" ");
                LinkedList<Short> durability = new LinkedList<Short>();
                for (String s : args) {
                    try {
                        if (Short.parseShort(s) >= 0) {
                            durability.add(Short.parseShort(s));
                        } else {
                            context.getForWhom().sendRawMessage(ChatColor.RED 
                                    + Lang.get("invalidMinimum").replace("<number>", "0"));
                            return new BlockShearDurabilityPrompt(context);
                        }
                    } catch (NumberFormatException e) {
                        context.getForWhom().sendRawMessage(ChatColor.LIGHT_PURPLE + s + " " + ChatColor.RED 
                                + Lang.get("stageEditorNotListofNumbers"));
                        return new BlockShearDurabilityPrompt(context);
                    }
                }
                context.setSessionData(pref + CK.S_CUT_DURABILITY, durability);
            }
            return new BlocksShearListPrompt(context);
        }
    }
}
