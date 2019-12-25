package tech.wetech.mybatis;

import tech.wetech.mybatis.domain.Page;

/**
 * @author cjbi
 */
public class ThreadContext {

    private static final ThreadLocal<Page> PAGE_THREAD_LOCAL = new ThreadLocal<>();

    public static void doPage(Page page) {
        PAGE_THREAD_LOCAL.set(page);
    }

    public static void doPage(int pageNumber, int pageSize) {
        Page page = new Page(pageNumber, pageSize);
        PAGE_THREAD_LOCAL.set(page);
    }

    public static void doPage(int pageNumber, int pageSize, boolean count) {
        Page page = new Page(pageNumber, pageSize, count);
        PAGE_THREAD_LOCAL.set(page);
    }

    public static void doPageWithOffset(int offset, int limit) {
        Page page = new Page(offset / limit + 1, limit);
        PAGE_THREAD_LOCAL.set(page);
    }

    public static void doPageWithOffset(int offset, int limit, boolean count) {
        Page page = new Page(offset / limit + 1, limit, count);
        PAGE_THREAD_LOCAL.set(page);
    }

    public static void setPage(Page page) {
        PAGE_THREAD_LOCAL.set(page);
    }

    public static Page getPage() {
        return PAGE_THREAD_LOCAL.get();
    }

    public static void removePage() {
        PAGE_THREAD_LOCAL.remove();
    }

}
