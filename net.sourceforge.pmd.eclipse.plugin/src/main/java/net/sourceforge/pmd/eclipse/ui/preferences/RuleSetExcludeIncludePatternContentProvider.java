/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.eclipse.ui.preferences;

import net.sourceforge.pmd.RuleSet;

/**
 * This class implements a content provider for the ruleset exclude/include
 * pattern tables of the PMD Preference page
 *
 */
public class RuleSetExcludeIncludePatternContentProvider extends AbstractStructuredContentProvider {

    private final boolean exclude;

    private static final RuleSetExcludeIncludePattern[] EMPTY_RULE_SET_PATTERN = new RuleSetExcludeIncludePattern[0];

    public RuleSetExcludeIncludePatternContentProvider(boolean exclude) {
        this.exclude = exclude;
    }

    /**
     * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(Object)
     */
    public RuleSetExcludeIncludePattern[] getElements(Object inputElement) {

        if (inputElement instanceof RuleSet) {
            RuleSet ruleSet = (RuleSet) inputElement;
            int patternCount = exclude ? ruleSet.getFileExclusions().size() : ruleSet.getFileInclusions().size();
            RuleSetExcludeIncludePattern[] patternList = new RuleSetExcludeIncludePattern[patternCount];
            for (int i = 0; i < patternList.length; i++) {
                patternList[i] = new RuleSetExcludeIncludePattern(ruleSet, exclude, i);
            }
            return patternList;
        }

        return EMPTY_RULE_SET_PATTERN;
    }
}
